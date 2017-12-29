package bitso;

import static org.asynchttpclient.Dsl.asyncHttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.asynchttpclient.ws.WebSocket;
import org.asynchttpclient.ws.WebSocketTextListener;
import org.asynchttpclient.ws.WebSocketUpgradeHandler;

import bitsows.BitsoAPI;
import model.Ask;
import model.Bid;
import model.BitsoOrder;
import model.Channel;
import model.DiffOrdersPayload;
import model.Message;
import model.OrderBook;
import model.Svalue;
import util.JsonParser;

public class Solution {
 
	private final static String BITSO_URL = "wss://ws.bitso.com";
	
	public  final static int TRADE_POLL_INTERVAL = 10*1000;
	
	public  final static String BTC_MXN_BOOK = "btc_mxn";
	public  final static String DIFF_ORDERS="diff-orders";
	public  final static String ACTION_SUBSCRIBE="subscribe";
	
	static boolean orderBookObtained = Boolean.FALSE;
	 
	static List<Message> orders = new ArrayList<Message>();
	
	static Operation bids = new Operation();
	static Operation asks = new Operation();
	
	private static int X;
	private static int M;
	private static int N;
  
	
//	static SocketIOServer server;
	
	public static void main(String[] args)  {
		

		try {
 
			 
				X=Integer.parseInt(args[0]);
				M=Integer.parseInt(args[1]);
				N=Integer.parseInt(args[2]);	
			
	      } catch(IllegalArgumentException exc){
	           throw new IllegalArgumentException(exc);
	      }
		
		try {
			
				listenChannel();
				getOrderBooks();
				pollTrades();
			
				
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	 
		
		
	}


	
	private static void listenChannel() throws InterruptedException, ExecutionException{
		
		AsyncHttpClient asyncHttpClient = asyncHttpClient();
		
		asyncHttpClient.prepareGet(BITSO_URL)
			      .execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(
			          new WebSocketTextListener() {
			        	  
						@Override
						public void onOpen(WebSocket websocket) {
							  Channel c = new Channel(ACTION_SUBSCRIBE,BTC_MXN_BOOK,DIFF_ORDERS);
				        	  
				        	  String str=JsonParser.toJson(c);
				        	
				              websocket.sendMessage(str);
							
						}
						
						@Override
						public void onError(Throwable t) {
							
						}
						
						@Override
						public void onClose(WebSocket websocket) {
						
							
						}
						
						@Override
						public void onMessage(String msg) {
 						    
						  
							   Message m=  (Message) JsonParser.fromJson(msg,Message.class);
							   
							   if(m.getPayload().isPresent() && m.getType().equals(DIFF_ORDERS)){
								   
								   if(orderBookObtained){
									   handleMessage(m);
									   handleTrade(m);
								   }else{
									   orders.add(m);
								   }
								  
							   }
							   
							  
						}
					}).build()).get();
		
		
	}
	
	private static void getOrderBooks(){
		
		
		BitsoAPI bitsoAPI=new BitsoAPI();
	
		ListenableFuture<Response> whenResponse = (ListenableFuture<Response>) bitsoAPI.getOrderBook(BTC_MXN_BOOK, Optional.of(false));
		
		Runnable callback = () -> {

			try  {

				
				
				Response response = whenResponse.get();
				
				String str = response.getResponseBody();
			 
				OrderBook ob= (OrderBook) JsonParser.fromJson(str,OrderBook.class);
				
				Integer sequence = ob.getPayload().getSequence();
				
				for(Bid bid:ob.getPayload().getBids()){
					bids.manageOrder(bid.getOid(),new OrderUpdate(bid.getOid(), bid.getPrice(), bid.getAmount(), bid.getBook(),sequence, Svalue.OPEN.toString()));
				}
				
				for(Ask ask:ob.getPayload().getAsks()){
					asks.manageOrder(ask.getOid(),new OrderUpdate(ask.getOid(), ask.getPrice(), ask.getAmount(), ask.getBook(),sequence, Svalue.OPEN.toString()));
				}
				
				
			List<Message> recentOrders= orders.stream()
						       				  .filter( m -> m.getSequence() > ob.getPayload().getSequence())
						       				  .collect(Collectors.toList());
 
			 for(Message message: recentOrders){
				 handleMessage(message);
			 }
			 
			 orders.clear();
			  
			 
			 orderBookObtained = Boolean.TRUE;
			 
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		};
		
		Executor executor  = Executors.newSingleThreadExecutor();
		
		whenResponse.addListener(callback, executor);		
		
	}
	
	private static void pollTrades(){
		
		 TimerTask timerTask = new TradeTimerTask();
	        
	     Timer timer = new Timer(true);
	     timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
		
		
	}
	
	private static void handleMessage(Message message){
		
		
		
		Optional<List<DiffOrdersPayload>> payload = message.getPayload();
		
		if(!payload.isPresent()){
			return;
		}
		
		List<DiffOrdersPayload> list = payload.get();
		
		for(DiffOrdersPayload diff: list){
			
			String orderId= diff.getO();
			
			OrderUpdate ou= new OrderUpdate(orderId,diff.getV(),diff.getA(),message.getBook(),message.getSequence(),diff.getS());
			
			if(diff.getT().equals(BitsoOrder.BUY.toString())){
				bids.manageOrder(orderId, ou);
			}else{
				asks.manageOrder(orderId, ou);
			}
			
		}
	}
	
	private static void handleTrade(Message message){
		
		
	}
	
	
	public static class TradeTimerTask extends TimerTask {

		BitsoAPI bitsoAPI=new BitsoAPI();
		
		@Override
		public void run() {

			Future<Response> whenResponse = bitsoAPI.getTrades(BTC_MXN_BOOK, Optional.empty(), Optional.empty(), Optional.of(X));

			try {
				Response response = whenResponse.get();
				
				String str = response.getResponseBody();
				
				System.out.println(str);
				
				
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
		}

	}

	
	
	
	
}
