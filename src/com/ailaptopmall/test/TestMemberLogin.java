package com.ailaptopmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.exception.LoginFailedException;

public class TestMemberLogin {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/ailm";
	private static final String USER_ID = "root";
	private static final String DB_PWD = "1234";	
	
	private static final String SELECT_CUSTOMER =
			"SELECT account, password, id, email, phone, name, "
			+" birthday, gender, address, subscribed, discount FROM customers "
			+" WHERE account=? ";		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入帳號:");  //clou40308
		String account = scanner.next();
		
		System.out.println("請輸入密碼:");  //a123456
		String password = scanner.next(); 
		
		System.out.printf("輸入了帳號: %s,密碼: %s\n", account, password); 
		scanner.close();
		Customer c = null;
		
		//JDBC
		try {			
			Class.forName(DRIVER); //1. 載入類別(Driver)			
			try (
					Connection connection = DriverManager.getConnection(URL, USER_ID, DB_PWD);//2.建立連線				
					PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMER); //3.準備指令，可避免發生SQL Injection					
				){
				
				pstmt.setString(1, account); //3.1傳入?的值
				//pstmt.setString(2, password); //3.1傳入?的值
				try(
						ResultSet rs = pstmt.executeQuery(); //4.執行指令		
					){
					while(rs.next()) { //5.讀取rs
						c = new Customer();
						String theAccount = rs.getString("account");
						if(!theAccount.equals(account)) {
							throw new LoginFailedException("登入失敗，帳號不正確");
						}
						c.setAccount(rs.getString("account"));
						c.setPassword(rs.getString("password"));
						c.setId(rs.getString("id"));					
						c.setEmail(rs.getString("email"));
						c.setPhone(rs.getString("phone"));
						c.setName(rs.getString("name"));
						c.setBirthday(rs.getString("birthday"));					
						c.setGender(rs.getString("gender").charAt(0));					
						c.setAddress(rs.getString("address"));
						c.setSubscribed(rs.getBoolean("subscribed"));						
						System.out.println(c); //for test
					}
				}
				
				if(c!=null && password!=null && password.equals(c.getPassword())) {
					System.out.printf("登入成功，%s 你好!\n", c.getName());
					return ;
				}		
			} catch (LoginFailedException e) {
				Logger.getLogger("XxxxxXxxxxx").log(Level.SEVERE, "登入失敗，帳號不正確", e);//for developer, tester, admin	
			} catch (SQLException e) {
				Logger.getLogger("XxxxxXxxxxx").log(Level.SEVERE, "[建立連線|執行指令]失敗", e);//for developer, tester, admin				
			}
			System.err.println("登入失敗!帳號或密碼不正確");			
		} catch (ClassNotFoundException e) {
			Logger.getLogger("XxxxxXxxxxx").log(Level.SEVERE, "載入Driver失敗", e);//for developer, tester, admin
		}				
		System.out.println("The End");

	}

}
