package bitso;

import java.math.BigDecimal;

public class OrderUpdate {
	
    private String orderId;
    private BigDecimal price;
    private BigDecimal amount;
    private String book;
    private int sequence;
    private String sValue;
    
	public OrderUpdate(String orderId, BigDecimal price, BigDecimal amount, String book, int sequence,String sValue) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.amount = amount;
		this.book = book;
		this.sequence = sequence;
		this.sValue = sValue;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getsValue() {
		return sValue;
	}

	public void setsValue(String sValue) {
		this.sValue = sValue;
	}
    
    
    
    
}
