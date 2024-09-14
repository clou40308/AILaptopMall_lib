package com.ailaptopmall.service;

import com.ailaptopmall.entity.Member;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.exception.LoginFailedException;

public class MemberService {

	private MembersDAO dao = new MembersDAO();

	public Member login(String account, String password) throws AILMException {
		if (account == null || account.length() == 0 || password == null || password.length() == 0)
			throw new IllegalArgumentException("登入會員必須輸入帳號、密碼");

		Member m = dao.selectById(account);
		if (m != null && password != null && password.equals(m.getPassword())) {
			return m;
		}

		throw new LoginFailedException("登入失敗，帳號或密碼不正確");
	}

	public void register(Member c) throws AILMException {
		if (c == null)
			throw new IllegalArgumentException("註冊會員時客戶物件不得為null");
		dao.insert(c);
	}
}
