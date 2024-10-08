package com.ailaptopmall.service;

import com.ailaptopmall.entity.Order;
import com.ailaptopmall.exception.AILMException;

public class OrderService {
	private OrdersDAO dao = new OrdersDAO();
	
	public void checkOut(Order order)throws AILMException{
		if(order==null) throw new IllegalArgumentException(
							"結帳時，訂單物件不得為null");
		dao.insert(order);
	}
}
