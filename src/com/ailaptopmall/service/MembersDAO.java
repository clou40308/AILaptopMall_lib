package com.ailaptopmall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.ailaptopmall.entity.Member;
import com.ailaptopmall.entity.VIP;
import com.ailaptopmall.exception.AILMDataInvalidException;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.exception.LoginFailedException;

public class MembersDAO {
	private static final String SELECT_MEMBER =
			"SELECT account, password, id, email, phone, name, "
			+" birthday, gender, address, subscribed, discount FROM members "
			+" WHERE account=? ";			
		
	Member selectById(String account)throws AILMException{
		Member m = null;
			
			try (
					Connection connection = MySQLConnection.getConnection();//1,2. 取得連線
					PreparedStatement pstmt = connection.prepareStatement(SELECT_MEMBER); //3.準備指令			
				){			
				pstmt.setString(1, account);//3.1傳入?的值			
				try(	
						ResultSet rs = pstmt.executeQuery(); //4. 執行指令 
					){
					//5.處理rs
					while(rs.next()) {
						String theAccount = rs.getString("account");
						if(!theAccount.equals(account)) {
							throw new LoginFailedException("登入失敗，帳號不正確");
						}
						int discount = rs.getInt("discount");
						if(discount>0) { //折扣>0
							VIP vip = new VIP();
							vip.setDiscount(discount);
							m = vip;
						}else { //否則
							m = new Member();   //建立一般Customer物件
						}
						m.setAccount(rs.getString("account"));
						m.setPassword(rs.getString("password"));
						m.setId(rs.getString("id"));					
						m.setEmail(rs.getString("email"));
						m.setPhone(rs.getString("phone"));
						m.setName(rs.getString("name"));
						m.setBirthday(rs.getString("birthday"));					
						m.setGender(rs.getString("gender").charAt(0));					
						m.setAddress(rs.getString("address"));
						m.setSubscribed(rs.getBoolean("subscribed"));								
					}
				}
			} catch (SQLException e) {
				throw new AILMException("用account查詢客戶失敗", e);
			}		
			return m;
		}

		private static final String INSERT_MEMBER="INSERT INTO members "
				+ " (account, password, id, email, phone, name, "
				+ "		birthday, gender, address, subscribed) "
				+ " VALUES(?,?,?,?,?,?,?,?, ?,?)";
		public void insert(Member m) throws AILMException{
			
			try (
					Connection connection = MySQLConnection.getConnection();//1, 2 取得連線
					PreparedStatement pstmt = connection.prepareStatement(INSERT_MEMBER); //3.準備指令
				){
				
				//3.1 傳入?的值
				pstmt.setString(1, m.getAccount());
				pstmt.setString(2, m.getPassword());
				pstmt.setString(3, m.getId());
				pstmt.setString(4, m.getEmail());
				pstmt.setString(5, m.getPhone());
				pstmt.setString(6, m.getName());
				pstmt.setString(7, String.valueOf(m.getBirthday()));
				pstmt.setString(8, String.valueOf(m.getGender()));
				pstmt.setString(9, m.getAddress());
				pstmt.setBoolean(10, m.isSubscribed());
				
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
}
