package model;

public class Channel {

	private String action;
	private String book;
	private String type;
	
	
	public Channel(){}
	
	public Channel(String action, String book, String type) {
		super();
		
		this.action = action;
		this.book = book;
		this.type = type;
	}
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
