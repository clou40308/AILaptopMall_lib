package com.ailaptopmall.entity;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class VIP extends Member {

	private int discount = 5; // 2% ~ 15% off

	public VIP() {
		super();
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if (discount >= 2 && discount <= 15) {
			this.discount = discount;
		} else {		
			String msg = String.format("VIP折扣必須在2%~15%之間\n");
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getDiscountString() {
		int discount = 100 - this.discount;
		if (discount % 10 == 0) {
			discount = discount / 10;
		}

		return discount + "折";
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ",\n VIP折扣為:" + discount + "% off, 即為" + getDiscountString() + "]";
	}
}
