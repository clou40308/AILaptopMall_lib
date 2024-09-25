package com.ailaptopmall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.entity.VIP;
import com.ailaptopmall.exception.AILMDataInvalidException;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.exception.LoginFailedException;

public class CustomersDAO {
	private static final String SELECT_CUSTOMER =
			"SELECT account, password, id, email, phone, name, "
			+" birthday, gender, address, subscribed, discount FROM customers "
			+" WHERE account=? ";			
		
	Customer selectById(String account)throws AILMException{
		Customer c = null;
			
			try (
					Connection connection = MySQLConnection.getConnection();//1,2. 取得連線
					PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMER); //3.準備指令			
				){			
				pstmt.setString(1, account);//3.1傳入?的值			
				try(	
						ResultSet rs = pstmt.executeQuery(); //4. 執行指令 
					){
					//5.處理rs
					while(rs.next()) {
						int discount = rs.getInt("discount");
						if(discount>0) { //折扣>0
							VIP vip = new VIP();
							vip.setDiscount(discount);
							c = vip;
						}else { //否則
							c = new Customer();   //建立一般Customer物件
						}
						String theAccount = rs.getString("account");
						c.setAccount(theAccount);
						c.setPassword(rs.getString("password"));
						c.setId(rs.getString("id"));					
						c.setEmail(rs.getString("email"));
						c.setPhone(rs.getString("phone"));
						c.setName(rs.getString("name"));
						c.setBirthday(rs.getString("birthday"));					
						c.setGender(rs.getString("gender").charAt(0));					
						c.setAddress(rs.getString("address"));
						c.setSubscribed(rs.getBoolean("subscribed"));								
					}
				}
			} catch (SQLException e) {
				throw new AILMException("用[帳號]查詢客戶失敗", e);
			}		
			return c;
		}

		private static final String INSERT_CUSTOMER="INSERT INTO customers "
				+ " (account, password, id, email, phone, name, "
				+ "		birthday, gender, address, subscribed) "
				+ " VALUES(?,?,?,?,?,?,?,?, ?,?)";
		public void insert(Customer c) throws AILMException{
			
			try (
					Connection connection = MySQLConnection.getConnection();//1, 2 取得連線
					PreparedStatement pstmt = connection.prepareStatement(INSERT_CUSTOMER); //3.準備指令
				){
				
				//3.1 傳入?的值
				pstmt.setString(1, c.getAccount());
				pstmt.setString(2, c.getPassword());
				pstmt.setString(3, c.getId());
				pstmt.setString(4, c.getEmail());
				pstmt.setString(5, c.getPhone());
				pstmt.setString(6, c.getName());
				pstmt.setString(7, String.valueOf(c.getBirthday()));
				pstmt.setString(8, String.valueOf(c.getGender()));
				pstmt.setString(9, c.getAddress());
				pstmt.setBoolean(10, c.isSubscribed());
				
				pstmt.executeUpdate(); //4.執行指令，SQLIntegrityConstraintViolationException
			}catch(SQLIntegrityConstraintViolationException e) {
				String column = "";
				if(e.getMessage().indexOf("email_UNIQUE")>=0) {
					column="email";
				}else if(e.getMessage().indexOf("phone_UNIQUE")>=0) {
					column="手機號碼";
				}else if(e.getMessage().indexOf("id_UNIQUE")>=0) {
					column="身分證字號";
				}else if(e.getMessage().indexOf("PRIMARY")>=0) {
					column="帳號";
				}else {
					throw new AILMException("註冊會員失敗:" + e.getErrorCode(), e);
				}
				
				String msg = String.format("註冊會員失敗,%s已經重複註冊", column);
				throw new AILMDataInvalidException(msg, e);
			} catch (SQLException e) {			
				throw new AILMException("註冊會員失敗:" + e.getErrorCode(), e);
			}		
		}
		
		private static final String UPDATE_CUSTOMER="UPDATE customers "
				+ "SET password=?, id=?, email=?, phone=?, name=?, "
				+ "	birthday=?, gender=?, address=?, subscribed=? "
				+ " WHERE account=?";
		public void update(Customer c)  throws AILMException{
			
			try (
					Connection connection = MySQLConnection.getConnection();//1, 2 取得連線
					PreparedStatement pstmt = connection.prepareStatement(UPDATE_CUSTOMER); //3.準備指令
				){
				
				//3.1 傳入?的值
				pstmt.setString(10, c.getAccount());
				pstmt.setString(1, c.getPassword());
				pstmt.setString(2, c.getId());
				pstmt.setString(3, c.getEmail());
				pstmt.setString(4, c.getPhone());
				pstmt.setString(5, c.getName());
				pstmt.setString(6, String.valueOf(c.getBirthday()));
				pstmt.setString(7, String.valueOf(c.getGender()));
				pstmt.setString(8, c.getAddress());
				pstmt.setBoolean(9, c.isSubscribed());
				
				pstmt.executeUpdate(); //4.執行指令，SQLIntegrityConstraintViolationException
			}catch(SQLIntegrityConstraintViolationException e) {
				String column = "";
				if(e.getMessage().indexOf("email_UNIQUE")>=0) {
					column="email";
				}else if(e.getMessage().indexOf("phone_UNIQUE")>=0) {
					column="手機號碼";
				}else if(e.getMessage().indexOf("PRIMARY")>=0) {
					column="身分證號";
				}else {
					throw new AILMException("修改會員失敗:" + e.getErrorCode(), e);
				}
				
				String msg = String.format("修改會員失敗,%s已經重複註冊", column);
				throw new AILMDataInvalidException(msg, e);
			} catch (SQLException e) {			
				throw new AILMException("修改會員失敗:" + e.getErrorCode(), e);
			}		
		}
}
