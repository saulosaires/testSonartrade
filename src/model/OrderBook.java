package model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class OrderBook {

	private Boolean success;

	@SerializedName("payload")
	private OrderBookPayload payload;

	public OrderBook(Boolean success, OrderBookPayload payload) {
		super();
		this.success = success;
		this.payload = payload;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public OrderBookPayload getPayload() {
		return payload;
	}

	public void setPayload(OrderBookPayload payload) {
		this.payload = payload;
	}

 
	
	
}
