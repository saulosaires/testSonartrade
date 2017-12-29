package model;

import java.math.BigDecimal;

public class Bid extends Order {

	public Bid(String book, BigDecimal price, BigDecimal amount, String oid) {
		super(book, price, amount, oid);

	}

}
