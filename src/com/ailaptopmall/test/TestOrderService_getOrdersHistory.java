package com.ailaptopmall.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.entity.Order;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.CustomerService;
import com.ailaptopmall.service.OrderService;

public class TestOrderService_getOrdersHistory {
	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		OrderService oService = new OrderService();

		try {
			Customer member = cService.login("clou40308", "a123456");
			List<Order> list = oService.getOrdersHistory(member);
			System.out.println(list);
		} catch (AILMException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
