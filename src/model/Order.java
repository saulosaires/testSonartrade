package model;

import java.math.BigDecimal;

public class Order {

	 private String book;
	 private BigDecimal price;
	 private BigDecimal amount;
	 private String oid;
	 
	 
	public Order(String book, BigDecimal price, BigDecimal amount, String oid) {
		super();
		this.book = book;
		this.price = price;
		this.amount = amount;
		this.oid = oid;
	}


	public String getBook() {
		return book;
	}


	public void setBook(String book) {
		this.book = book;
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


	public String getOid() {
		return oid;
	}


	public void setOid(String oid) {
		this.oid = oid;
	}
	 
	 
	 
	
}
