package bitsows;

import static org.asynchttpclient.Dsl.asyncHttpClient;

import java.util.Optional;
import java.util.concurrent.Future;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.Response;

/**
 * @author Saulo Aires
 *
 */
public class BitsoAPI {

	private final String URL_BITSO="https://api.bitso.com/v3/";
	
	private final String URL_BITSO_ORDER_BOOK = URL_BITSO+"order_book";
	private final String URL_BITSO_TRADES     = URL_BITSO+"trades";
	
	private final String PARAM_BOOK="book";
	private final String PARAM_AGGREGATE="aggregate";
	private final String PARAM_MARKER="marker";	
	private final String PARAM_SORT="sort";
	private final String PARAM_LIMIT="limit";		
	
	
	/**
	 * @param book 	    Specifies which book to use Required:YES
	 * @param aggregate Specifies if orders should be aggregated by price. Required:NO Default:true
	 * 
	 * 
     *
	 * **/
	public Future<Response> getOrderBook(String book,Optional<Boolean> aggregate){
		
		AsyncHttpClient asyncHttpClient = asyncHttpClient();
	
		 BoundRequestBuilder request = asyncHttpClient.prepareGet(URL_BITSO_ORDER_BOOK);
		 
		 request.addQueryParam(PARAM_BOOK,book);
		 
		 if(aggregate.isPresent()){
			 request.addQueryParam(PARAM_AGGREGATE,aggregate.get().toString());
		 }
		
		
		return request.execute();
	}
	
	/**
	 * @param book 	    Specifies which book to use Required:YES
	 * @param marker    Returns objects that are older or newer (depending on 'sort’) than the object with this ID. Required:NO 
	 * @param sort 	    Specifies ordering direction of returned objects ('asc’, 'desc’) Default:desc
	 * @param limit 	Specifies number of objects to return. (Max is 100) Default:25
     *
	 * **/
	public Future<Response> getTrades(String book,Optional<Boolean> marker,Optional<String> sort,Optional<Integer> limit){
		
		AsyncHttpClient asyncHttpClient = asyncHttpClient();
	
		 BoundRequestBuilder request = asyncHttpClient.prepareGet(URL_BITSO_TRADES);
		 
		 request.addQueryParam(PARAM_BOOK,book);
		 
		 if(marker.isPresent()){
			 request.addQueryParam(PARAM_MARKER,marker.get().toString());
		 }

		 if(sort.isPresent()){
			 request.addQueryParam(PARAM_SORT,sort.get().toString());
		 }

		 if(limit.isPresent()){
			 request.addQueryParam(PARAM_LIMIT,limit.get().toString());
		 }

		
		return request.execute();
	}
	
	
	
}
