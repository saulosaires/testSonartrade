package model;

public enum Svalue {

	OPEN("open"),
	CANCELLED("cancelled");
	
	private String sValue;

	Svalue(String sValue) {
        this.sValue = sValue;
    }

	public String getsValue() {
		return sValue;
	}

 
    
	
	
}
