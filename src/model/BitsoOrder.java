package model;

public enum BitsoOrder {

	BUY("0"),
	SELL("1");
	
	private String bitValue;

	BitsoOrder(String bitValue) {
        this.bitValue = bitValue;
    }

	public String getBitValue() {
		return bitValue;
	}
 
    
	
	
}
