package com.ailaptopmall.entity;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class SpecialOffer extends Product{
	
	private int discount; //required, 1% ~ 90% off	
	
	public SpecialOffer() {
		super();
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount >= 1 && discount <= 90) {
			this.discount = discount;
		}else {
			String msg = String.format("特價品折扣必須在1%~90%之間\n");
			throw new AILMDataInvalidException(msg);
		}
	}
	public String getDiscountString() {
		int discount = 100-this.discount;
		if(discount % 10 ==0) {
			discount = discount/10;
		}		
		return discount+"折";		
	}
	
	/**
	 * 查詢售價
	 * @return
	 */	
	@Override
	public double getUnitPrice() {
		double rtn = super.getUnitPrice() * (100-discount)/100; 
		return rtn;
	}
	
	/**
	 * 查詢定價
	 * @return
	 */
	public double getListPrice() {
		return super.getUnitPrice();
	}

	@Override
	public String toString() {
		return "[" + super.toString() 
			+ "\n 折扣: " + discount + "%off 即為" + getDiscountString()
			+ "\n 售價為: " + getUnitPrice()
		+ "]";
	}
}
