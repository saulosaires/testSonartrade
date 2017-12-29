package model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class OrderBookPayload {

	@SerializedName("updated_at")
	private Date updatedAt;
	
	private Integer sequence;
	
	@SerializedName("asks")
	private List<Ask> asks;
	
	@SerializedName("bids")
	private List<Bid> bids;

	public OrderBookPayload(Date updatedAt, Integer sequence, List<Ask> asks, List<Bid> bids) {
		super();
		this.updatedAt = updatedAt;
		this.sequence = sequence;
		this.asks = asks;
		this.bids = bids;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public List<Ask> getAsks() {
		return asks;
	}

	public void setAsks(List<Ask> asks) {
		this.asks = asks;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	
	
	
}
