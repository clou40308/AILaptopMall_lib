package com.ailaptopmall.service;

import java.util.List;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.entity.Order;
import com.ailaptopmall.exception.AILMException;

public class OrderService {
	private OrdersDAO dao = new OrdersDAO();
	
	public void checkOut(Order order)throws AILMException{
		if(order==null) throw new IllegalArgumentException(
							"結帳時，訂單物件不得為null");
		dao.insert(order);
	}
	public List<Order> getOrdersHistory(Customer member)throws AILMException{
		if(member==null) throw new IllegalArgumentException(
				"查詢歷史訂單，member物件不得為null");
		return dao.selectOrdersHistory(member.getAccount());
	}
}
