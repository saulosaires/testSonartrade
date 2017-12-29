package model;

import java.math.BigDecimal;

public class Ask extends Order {

	public Ask(String book, BigDecimal price, BigDecimal amount, String oid) {
		super(book, price, amount, oid);

	}

}
