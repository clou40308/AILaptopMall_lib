package com.ailaptopmall.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.exception.AILMDataInvalidException;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.CustomerService;

public class TestCustomerService_update {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入帳號:");//clou40308
		String account = scanner.next();		
		
		System.out.println("請輸入密碼:");//a123456
		String password = scanner.next();		
		
		try {
			
			CustomerService service = new CustomerService();
			Customer c = service.login(account, password);
			System.out.println(c);
			
			c.setName("小栗旬");
			service.update(c);
			System.out.println("修改成功:");
			System.out.println(c);
		}catch(AILMDataInvalidException e) {
			System.err.println(e.getMessage()); //for user
		} catch (AILMException e) {
			System.err.println(e.getMessage()+", 請聯絡admin"); //for user
			Logger.getLogger("").log(Level.SEVERE,e.getMessage(),e);
		}
	}

}
