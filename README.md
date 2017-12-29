# testSonartrade



Schedule the polling of trades over REST.

	File: Main.java  inner class TradeTimerTask.java

Request a book snapshot over REST.

File: BitsoAPI.java  
method: public Future<Response> getOrderBook(String book,Optional<Boolean> aggregate)

Listen for diff-orders over websocket.

File: Main.java
method: listenChannel()

Replay diff-orders.

File: Main.java
method: getOrderBooks()


Use config option X to request  recent trades.

File: BitsoAPI.java  
method: public Future<Response> getTrades(String book,Optional<Boolean> marker,Optional<String> sort,Optional<Integer> limit)

Use config option X to limit number of ASKs displayed in UI.

File: Operation.java  
method:public List<Order> getBestorders(int n);

The loop that causes the trading algorithm to reevaluate.

none




