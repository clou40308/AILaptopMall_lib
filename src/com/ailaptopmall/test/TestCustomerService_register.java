package com.ailaptopmall.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.exception.AILMDataInvalidException;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.CustomerService;

public class TestCustomerService_register {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("請輸入帳號:");// clou40308
		String account = scanner.next();

		System.out.println("請輸入密碼:");// a123456
		String password = scanner.next();

		System.out.println("請輸入身分證字號:");// F128546809
		String id = scanner.next();

		System.out.println("請輸入email:");// clou40308@gmail.com
		String email = scanner.next();

		System.out.println("請輸入手機號碼:");// 0922656613
		String phone = scanner.next();

		System.out.println("請輸入姓名:");// 周作軒
		String name = scanner.next();

		Customer c = new Customer();
		try {
			c.setAccount(account);
			c.setPassword(password);
			c.setId(id);
			c.setEmail(email);
			c.setPhone(phone);
			c.setName(name);
			c.setBirthday("1994-03-30");
			c.setGender(Customer.MALE);
			c.setAddress("台北市");
			c.setSubscribed(false);

			System.out.println(c);

			CustomerService service = new CustomerService();
			service.register(c);
			System.out.println("註冊成功");
		} catch (AILMDataInvalidException e) {
			System.err.println(e.getMessage()); // for user
		} catch (AILMException e) {
			System.err.println(e.getMessage() + ", 請聯絡admin"); // for user
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		}

	}

}
