package model;

import java.util.List;
import java.util.Optional;

import com.google.gson.annotations.SerializedName;

public class Message {
 
	private String type;
	private String book;

	@SerializedName("payload")
	private List<DiffOrdersPayload> payload;
	
	private Integer sequence;

	public Message(String type, String book, List<DiffOrdersPayload> payload, Integer sequence) {
		super();
		this.type = type;
		this.book = book;
		this.payload = payload;
		this.sequence = sequence;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Optional<List<DiffOrdersPayload>> getPayload() {

		return Optional.ofNullable(payload);
	}

	public void setPayload(List<DiffOrdersPayload> payload) {
		this.payload = payload;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	 
	
	
}
