package com.ailaptopmall.exception;

import com.ailaptopmall.entity.OrderItem;

public class StockShortageException extends AILMException {
	private final OrderItem item;
	private static final String errorMsg ="庫存不足";
	
	public StockShortageException(OrderItem item) {
		super(errorMsg);
		this.item = item;
	}

	public StockShortageException(String message,OrderItem item) {
		super(message);
		this.item = item;
	}

	@Override
	public String toString() {
		String msg = String.format("[%s-%s-%s]%s", 
				item.getProductId(),item.getSizeName(),item.getSpecName(),this.getMessage());
		return msg;
	}
	
	
}
