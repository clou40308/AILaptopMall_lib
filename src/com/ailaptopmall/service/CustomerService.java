package com.ailaptopmall.service;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.exception.LoginFailedException;

public class CustomerService {

	private CustomersDAO dao = new CustomersDAO();

	public Customer login(String account, String password) throws AILMException {
		if (account == null || account.length() == 0 || password == null || password.length() == 0)
			throw new IllegalArgumentException("登入會員必須輸入帳號、密碼");

		Customer c = dao.selectById(account);
		if (c != null && password != null && password.equals(c.getPassword())) {
			return c;
		}

		throw new LoginFailedException("登入失敗，帳號或密碼不正確");
	}

	public void register(Customer c) throws AILMException {
		if (c == null)
			throw new IllegalArgumentException("註冊會員時客戶物件不得為null");
		dao.insert(c);
	}
}
