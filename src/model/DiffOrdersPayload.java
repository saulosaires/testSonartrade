package model;

import java.math.BigDecimal;

public class DiffOrdersPayload {

	private Long d;//Unix timestamp
	private String r;//Rate
	private Integer t;//0 indicates buy 1 indicates sell
	private BigDecimal a;//Amount
	private BigDecimal v;//Value
	private String o;//Order ID
	private String s; 
	
	public DiffOrdersPayload(Long d, String r, Integer t, BigDecimal a, BigDecimal v, String o, String s) {
		super();
		this.d = d;
		this.r = r;
		this.t = t;
		this.a = a;
		this.v = v;
		this.o = o;
		this.s = s;
	}

	public Long getD() {
		return d;
	}

	public void setD(Long d) {
		this.d = d;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public Integer getT() {
		return t;
	}

	public void setT(Integer t) {
		this.t = t;
	}

	public BigDecimal getA() {
		return a;
	}

	public void setA(BigDecimal a) {
		this.a = a;
	}

	public BigDecimal getV() {
		return v;
	}

	public void setV(BigDecimal v) {
		this.v = v;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
	
	
}
