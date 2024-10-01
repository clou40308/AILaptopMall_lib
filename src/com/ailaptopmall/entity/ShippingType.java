package com.ailaptopmall.entity;

public enum ShippingType {
	SHOP("門市取貨"), HOME("宅配", 120), 
	STORE("超商取貨", 65),NO("無需貨運"); //第一行必須先宣告列舉值(最好用英文)
	
	private final String description;
	private final double fee;
	
	private ShippingType(String description) {
		this(description, 0);
	}

	private ShippingType(String description, double fee) {
		this.description = description;
		this.fee = fee;
	}	

	public String getDescription() {
		return description;
	}
	
	public double getFee() {
		return fee;
	}	
	
	@Override
	public String toString() {
		return this.description + (this.fee>0?"," + this.fee + "元":"");
	}
	
}
