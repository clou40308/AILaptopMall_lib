package com.ailaptopmall.entity;

import java.time.LocalDate;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class member {

	public String account;// 帳號 PKey,6~20個字元

	private String password;// 密碼 required,6~20個字元

	public String id; // 身分證字號 UNIQUE,required

	public String email;// UNIQUE,required

	public String phone;// UNIQUE,required

	public String name;// required,2~20個字元

	public LocalDate birthday;// required,須年滿12歲

	public char gender;// 性別 required, M:男|F:女|O:不願透漏

	public String address = "";// optional, 0-100個字元

	public boolean subscribed ;// 訂閱 optional

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		if (account.length() >= 6 && account.length() <= 20) {
			this.account = account;
		} else {
			String msg = String.format("帳號必須6~20個字元\n");
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() >= 6 && password.length() <= 20) {
			this.password = password;
		} else {
			String msg = String.format("密碼長度不正確，必須6~20個字元\n");
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (checkId(id)) {
			this.id = id;
		} else {
			String msg = String.format("ID(%s)不正確，必須符合ROC ID規則\n", id);
			throw new AILMDataInvalidException(msg);
		}
	}

	public boolean checkId(String id) {
		if (id != null && id.matches("[A-Z][1289][0-9]{8}")) {
			// 1. 將第1碼的英文字元轉成整數firstNumber(A123123123)
			char firstChar = id.charAt(0);
			int firstNumber = 0;
			if (firstChar >= 'A' && firstChar <= 'H') {
				firstNumber = firstChar - 'A' + 10;
			} else if (firstChar >= 'J' && firstChar <= 'N') {
				firstNumber = firstChar - 'A' + 18;
			} else if (firstChar >= 'P' && firstChar <= 'V') {
				firstNumber = firstChar - 'A' + 23;
			} else {
				switch (firstChar) {
				case 'I':
					firstNumber = 34;
					break;
				case 'O':
					firstNumber = 35;
					break;
				case 'W':
					firstNumber = 32;
					break;
				case 'X':
					firstNumber = 30;
					break;
				case 'Y':
					firstNumber = 31;
					break;
				case 'Z':
					firstNumber = 33;
				}
			}

			// 2. 依公式加總

			// 將firstNumber的十位數 *1 + firstNumber的十位數*9
			int sum = firstNumber / 10 + firstNumber % 10 * 9;
			// 依公視加總:
			// sum = sum + n1 * 8 + n2 * 7 + n3 * 6 + n4 * 5
			// + n5 * 4 + n6 * 3 + n7 * 2 + n8 *1 + n9 *1
			for (int i = 1; i < 10; i++) {
				sum = sum + (id.charAt(i) - '0') * (i == 9 ? 1 : 9 - i);
			}
			return true;
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {// 原始格式: ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
		if (email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) { // regexp lib搜尋
			this.email = email;
		} else {
			String msg = String.format("email(%s)格式不正確\n ", email);
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone != null && phone.matches("[0][9][0-9]{8}")) { // regexp lib搜尋
			this.phone = phone;
		} else {
			String msg = String.format("phone(%s)格式不正確\n ", phone);
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getName() {
		return name;
	}

	public static final int MIN_NAME_LENGTH = 2;
	public static final int MAX_NAME_LENGTH = 20;

	public void setName(String name) {
		if (name != null && name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH) {
			this.name = name;
		} else {
			String msg = String.format("姓名必須輸入且要有%s~%s個字元\n", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
			throw new AILMDataInvalidException(msg);
		}
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}
}
