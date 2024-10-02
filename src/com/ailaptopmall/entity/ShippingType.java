package com.ailaptopmall.entity;

public enum ShippingType {
	SHOP("門市取貨", new PaymentType[]{PaymentType.SHOP}), 
	HOME("宅配", 120, PaymentType.ATM, PaymentType.HOME, PaymentType.CARD), 
	STORE("超商取貨", 65, PaymentType.ATM,PaymentType.STORE,PaymentType.CARD),
	NO("無需貨運", PaymentType.ATM,PaymentType.CARD); //第一行必須先宣告列舉值(最好用英文)
	
	private final String description;
	private final double fee;
	
	private final PaymentType[] paymentTypeArray;
	
//	public PaymentType[] getPaymentTypeArray() {
//		return paymentTypeArray!=null?paymentTypeArray.clone():null;
//	}

	public String getPaymentTypeArrayStr() {//為了將對應PaymentType資料傳給前端
		StringBuilder data = new StringBuilder();
		if(paymentTypeArray!=null && paymentTypeArray.length>0) {
			for(PaymentType pType:paymentTypeArray) {
				if(data.length()>0) data.append(',');
				data.append(pType.name());
			}
		}		
		
		return data.toString();
	}
	
	private ShippingType(String description, PaymentType... paymentTypeArray) {
		this(description, 0, paymentTypeArray);
	}

	private ShippingType(String description, double fee, PaymentType... paymentTypeArray) {
		this.description = description;
		this.fee = fee;
		this.paymentTypeArray = paymentTypeArray;
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
