package com.ailaptopmall.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.entity.Order;
import com.ailaptopmall.entity.OrderStatusLog;
import com.ailaptopmall.exception.AILMException;

public class OrderService {
	private OrdersDAO dao = new OrdersDAO();
	
	public void checkOut(Order order)throws AILMException{
		if(order==null) throw new IllegalArgumentException(
							"結帳時，訂單物件不得為null");
		dao.insert(order);
	}
	public List<Order> getOrdersHistory(Customer member, int range) throws AILMException {
		if (member == null)
			throw new IllegalArgumentException("查詢歷史訂單, member物件不得為null");		
		
		return dao.selectOrdersHistory(member.getAccount(), range);
	}
	public Order getOrderById(Customer member, String orderId) throws AILMException{
		if(member==null) throw new IllegalArgumentException(
				"查詢指定訂單, member物件不得為null");
		
		if(orderId==null || orderId.length()==0) throw new IllegalArgumentException(
				"查詢指定訂單, 訂單編號必須給值");
		
		return dao.selectOrderById(member.getAccount(), orderId);
	}
	
	public void updateStatusToTransfered(Customer member, String orderId, //記得要 [alt+/] import LocalDate
	           String bank, String last5, double amount,LocalDate TransferedDate, String TransferedTime) throws AILMException {
	        if(member==null || orderId==null || !orderId.matches("\\d+")) {
	           throw new IllegalArgumentException("通知轉帳時，member|orderId不得為null");
	        }
	        StringBuilder paymentNote = new StringBuilder();
	        paymentNote.append(bank).append(", ").append(last5);
	        paymentNote.append(",轉帳金額:").append(amount);
	        paymentNote.append(",轉帳時間約:").append(TransferedDate).append(" ").append(TransferedTime);

	        dao.updateStatusToTransfered(member.getAccount(),Integer.parseInt(orderId), paymentNote.toString());
	    }
	
	public List<OrderStatusLog> getOrderStatusLog(String orderId)// 記得要import OrderStatusLog
			throws AILMException {
		return dao.selectOrderStatusLog(orderId);
	}
	
	 public void updateOrderStatusToPAID(Customer member,String orderId, String cardF6, String cardL4,
	            String auth, String paymentDate, String amount) throws AILMException {
	      StringBuilder paymentNote = new StringBuilder("信用卡號:");
	      paymentNote.append(cardF6==null?"4311-95":cardF6).append("**-****").append(cardL4==null?2222:cardL4);
	      paymentNote.append(",授權碼:").append(auth==null?"777777":auth);
	      paymentNote.append(",交易時間:").append(paymentDate==null?LocalDateTime.now():paymentDate); //必須import java.time.LocalDateTime
//	    paymentNote.append(",刷卡金額:").append(amount);
	      System.out.println("orderId = " + orderId);
	      System.out.println("customerId = " + member.getId());
	      System.out.println("paymentNote = " + paymentNote);
	      dao.updateOrderStatusToPAID(member.getAccount(), Integer.parseInt(orderId), paymentNote.toString());
	}
}
