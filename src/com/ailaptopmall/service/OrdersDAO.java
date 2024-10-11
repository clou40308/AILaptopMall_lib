package com.ailaptopmall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.entity.Order;
import com.ailaptopmall.entity.OrderItem;
import com.ailaptopmall.entity.PaymentType;
import com.ailaptopmall.entity.ShippingType;
import com.ailaptopmall.exception.AILMException;

public class OrdersDAO {
	private static final String INSERT_ORDERS = 
			"INSERT INTO orders(id, customer_account, created_date, careted_time, "
			+ "	shipping_type, shipping_fee, payment_type, payment_fee, "
			+ " recipient_name, recipient_email, recipient_phone, shipping_address) "
			+ " VALUES(?,?,?,?, ?,?,?,?, ?,?,?,?) ";
			
	
	private static final String INSERT_ORDER_ITEMS = 
			"INSERT INTO order_items "
			+ "	(order_id, product_id, size_name, spec_name, price, quantity) "
			+ " VALUES(?,?,?,?, ?,?) ";
	void insert(Order order) throws AILMException {
		try (
			Connection connection = MySQLConnection.getConnection();	//1,2. 取得連線
			PreparedStatement pstmt1 = connection.prepareStatement(INSERT_ORDERS,
									Statement.RETURN_GENERATED_KEYS);	//3.準備指令pstmt1
			PreparedStatement pstmt2 = connection.prepareStatement(INSERT_ORDER_ITEMS)//3.準備指令pstmt2
		){		
			connection.setAutoCommit(false);	//關閉[交易自動確認]，類似connection.beginTransaction()
			try {
			//新增訂單
				//3.1 傳入pstmt1的?的值
				pstmt1.setInt(1, order.getId());
				pstmt1.setString(2, order.getMember().getAccount());
				pstmt1.setString(3, order.getCreatedDate().toString());
				pstmt1.setString(4, order.getCreatedTime().toString());
				
				pstmt1.setString(5, order.getShippingType().name());
				pstmt1.setDouble(6, order.getShippingFee());
				
				pstmt1.setString(7, order.getPaymentType().name());
				pstmt1.setDouble(8, order.getPaymentFee());
				
				pstmt1.setString(9, order.getRecipientName());
				pstmt1.setString(10, order.getRecipientEmail());
				pstmt1.setString(11, order.getRecipientPhone());
				pstmt1.setString(12, order.getShippingAddress());
			
				//4. 執行指令pstmt1
				pstmt1.executeUpdate();
				
				//5.處理rs(取得AI的Key)
				try(ResultSet rs = pstmt1.getGeneratedKeys();){
					while(rs.next()) {
						order.setId(rs.getInt(1));
					}					
				}
				
			//新增訂單明細
				for(OrderItem item:order.getOrderItemsSet()) {
					item.setOrderId(order.getId());
					
					//3.1 傳入pstmt2的?的值
					pstmt2.setInt(1, item.getOrderId());
					pstmt2.setInt(2, item.getProductId());
					pstmt2.setString(3, item.getSizeName());
					pstmt2.setString(4, item.getSpecName());
					
					pstmt2.setDouble(5, item.getPrice());
					pstmt2.setInt(6, item.getQuantity());
					
					//4. 執行指令pstmt2
					pstmt2.executeUpdate();
				}				
				connection.commit();
			}catch(Exception e) {
				connection.rollback();
				throw e; //將e拋回原來的錯誤處理機制
			}finally {
				connection.setAutoCommit(true); //若有connection pool機制，需還原為預設值
			}			
		} catch (SQLException e) {
			throw new AILMException("建立訂單失敗!", e);
		}
	}
	
	private static final String SELECT_ORDERS_HISTORY =
			"SELECT id, customer_account, created_date, careted_time, status, "
			+ "	shipping_type, shipping_fee, payment_type, payment_fee, "
			+ " order_id, "
			+ " SUM(price * quantity) AS total_amount "
			+ " FROM orders "
			+ "	INNER JOIN order_items "
			+ "	ON orders.id = order_items.order_id "
			+ "	WHERE customer_account =? "
			+ " AND created_date BETWEEN date_add(curdate(), INTERVAL -1 MONTH) AND curdate() "
			+ " GROUP BY orders.id "
			+ " ORDER BY created_date DESC, careted_time DESC ";
	List<Order> selectOrdersHistory(String customerAccount) throws AILMException{
		List<Order>list = new ArrayList<>();
		
		try (
				Connection connection = MySQLConnection.getConnection(); //1,2 取得連線
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ORDERS_HISTORY);//3.準備指令		
			){
			//3.1 傳入?的值
			pstmt.setString(1, customerAccount);
			try(
					ResultSet rs = pstmt.executeQuery(); //4.執行指令
				){
					while(rs.next()) { //5.處理rs
						Order order = new Order();
						order.setId(rs.getInt("id"));
						
						Customer member = new Customer();
						member.setAccount(rs.getString("customer_account"));
						order.setMember(member);
						
						order.setCreatedDate(LocalDate.parse(rs.getString("created_date")));
						order.setCreatedTime(LocalTime.parse(rs.getString("careted_time")));
						order.setStatus(rs.getInt("status"));
						order.setShippingType(ShippingType.valueOf(rs.getString("shipping_type")));
						order.setShippingFee(rs.getDouble("shipping_fee"));
						order.setPaymentType(PaymentType.valueOf(rs.getString("payment_type")));
						order.setPaymentFee(rs.getDouble("payment_fee"));
						order.setTotalAmount(rs.getDouble("total_amount"));
						
						list.add(order);
					} 
				}
		} catch (SQLException e) {
			throw new AILMException("查詢歷史訂單失敗!", e);
		}
		return list;
	}

}
