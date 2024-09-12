package com.ailaptopmall.entity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class member {

	public String account;// 帳號 PKey,6~20個字元

	private String password;// 密碼 required,6~20個字元

	public String id; // 身分證字號 UNIQUE,required

	public String email;// UNIQUE,required

	public String phone;// UNIQUE,required

	public String name;// required,2~20個字元

	public LocalDate birthday;// required,須年滿6歲

	public char gender;// 性別 required, M:男|F:女|O:不願透漏

	public String address = "";// optional, 0-100個字元

	public boolean subscribed;// 訂閱 optional

	public member() {
		super();
	}

	public String getAccount() {
		return account;
	}

	public static final int MIN_ACCOUNT_LENGTH = 6;
	public static final int MAX_ACCOUNT_LENGTH = 20;

	public void setAccount(String account) {
		if (account.length() >= MIN_ACCOUNT_LENGTH && account.length() <= MAX_ACCOUNT_LENGTH) {
			this.account = account;
		} else {
			String msg = String.format("帳號長度不正確，必須%s~%s個字元\n", MIN_ACCOUNT_LENGTH, MAX_ACCOUNT_LENGTH);
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getPassword() {
		return password;
	}

	public static final int MIN_PWD_LENGTH = 6;
	public static final int MAX_PWD_LENGTH = 20;

	public void setPassword(String password) {
		if (password != null && password.length() >= MIN_PWD_LENGTH && password.length() <= MAX_PWD_LENGTH) {
			this.password = password;
		} else {
			String msg = String.format("密碼長度不正確，必須%s~%s個字元\n", MIN_PWD_LENGTH, MAX_PWD_LENGTH);
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 * @throws AILMDataInvalidException 當輸入的身分證號不正確
	 */
	public void setId(String id) {
		if (checkId(id)) {
			this.id = id;
		} else {
			String msg = String.format("ID(%s)不正確，必須符合ROC ID規則\n", id);
			throw new AILMDataInvalidException(msg);
		}
	}

	private static final String ROC_ID_PATTER = "[A-Z][1289][0-9]{8}";

	/**
	 * 依據ROC ID格式檢查公式檢查參數id是否為正確的ROC ID
	 * 
	 * @param id ROC ID字串
	 * @return true即為正確，否則為false
	 */
	public static boolean checkId(String id) {
		if (id != null && id.matches(ROC_ID_PATTER)) {
			// 1. 將第1碼的英文字元轉成整數firstNumber(A123456789)
			char firstChar = id.charAt(0);
			int firstNumber = 0;
			if (firstChar >= 'A' && firstChar <= 'H') {
				firstNumber = firstChar - 'A' + 10;
			} else if (firstChar >= 'J' && firstChar <= 'N') {
				firstNumber = firstChar - 'J' + 18;
			} else if (firstChar >= 'P' && firstChar <= 'V') { // P~V(23~29)
				firstNumber = firstChar - 'P' + 23;
			} else { // IOWXYZ(34,35,32,30,31,33)
				switch (firstChar) {
				case 'X':
					firstNumber = 30;
					break;
				case 'Y':
					firstNumber = 31;
					break;
				case 'W':
					firstNumber = 32;
					break;
				case 'Z':
					firstNumber = 33;
					break;
				default:
					return false;
				case 'I':
					firstNumber = 34;
					break;
				case 'O':
					firstNumber = 35;
					break;
				}
			}

			// System.out.printf("[checkId]firstNumber: %s\n", firstNumber); //for test
			// 2. 依公式將n1~n9加總

			// 將firstNumber的十位數 * 1 + firstNumber的個位數 * 9
			int sum = firstNumber / 10 + firstNumber % 10 * 9;

			// 依公式加總:
			// sum = sum + n1 * 8 + n2 * 7 + + n3 * 6 + n4 * 5
			// + n5 * 4 + n6 * 3 + + n7 * 2 + n8 * 1 + n9 * 1
			for (int i = 1, j = 8; i < 10; i++, j--) {
				// sum = sum + (id.charAt(i)-'0') * (j==0?1:j);
				sum += (id.charAt(i) - '0') * (j == 0 ? 1 : j);
			}

			return sum % 10 == 0;
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	public void setEmail(String email) {// 原始格式: ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
		if (email != null && email.matches(EMAIL_PATTERN)) { // regexp lib搜尋
			this.email = email;
		} else {
			String msg = String.format("email(%s)格式不正確\n", email);
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getPhone() {
		return phone;
	}

	public static final String PHONE_PATTERN = "[0-9-]{10,15}";

	public void setPhone(String phone) {
		if (phone != null && phone.matches(PHONE_PATTERN)) {
			this.phone = phone;
		} else {
			String msg = String.format("手機(%s)格式不正確\n", phone);
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

	public static final int MIN_AGE = 6;

	/**
	 * birthday屬性的**標準**setter
	 * 
	 * @param birthday LocalDate型態，代表出生日期物件
	 */
	public void setBirthday(LocalDate birthday) {
		if (birthday != null && getAge(birthday) >= MIN_AGE) {
			this.birthday = birthday;
		} else {
			String msg = String.format("生日日期(%s)必須輸入且須年滿%s歲\n", birthday, MIN_AGE);
			throw new AILMDataInvalidException(msg);
		}
	}

	/**
	 * 將 年,月,日 三個整數轉換成LocalDate物件 再呼叫setBirthday(LocalDate物件)間接指派給客戶的birthday屬性
	 * 
	 * @param year  int型態 客戶生日的年份
	 * @param month int型態 客戶生日的月份
	 * @param day   int型態 客戶生日的日期
	 */
	public void setBirthday(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
		this.setBirthday(date);
	}

	/**
	 * 將符合iso-8601的日期字串轉換成LocalDate物件
	 * 再呼叫setBirthday(LocalDate物件)**間接指派**給客戶的birthday屬性
	 * 
	 * @param dateString 符合iso-8601的日期字串，如: 2007-12-03
	 */
	public void setBirthday(String dateString) {
		try {
			LocalDate date = LocalDate.parse(dateString);
			this.setBirthday(date);
		} catch (DateTimeParseException e) {
			String msg = String.format("你輸入的日期: %s 不正確，必須符合iso8601日期格式\n", dateString);
			throw new AILMDataInvalidException(msg);
		}
	}

	/**
	 * 用[this.birthday屬性]算出年齡
	 * 
	 * @return this的年齡
	 */
	public int getAge() {
		return getAge(this.birthday);
	}

	/**
	 * 用[參數birthday]算出年齡
	 * 
	 * @param birthday 出生日期
	 * @return this的年齡
	 */
	public static int getAge(LocalDate birthday) {
		if (birthday != null) {
			int thisYear = LocalDate.now().getYear();
			int birthYear = birthday.getYear();
			int age = thisYear - birthYear;

			return age;
		} else {
			return -1; // TODO(可不做): 第13章 改成(拋出)throw XxxException物件
		}
	}

	public char getGender() {
		return gender;
	}

	public static final char MALE = 'M';
	public static final char FEMALE = 'F';
	public static final char OTHERS = 'O';

	public void setGender(char gender) {
		if (gender == MALE || gender == FEMALE || gender == OTHERS) {
			this.gender = gender;
		} else {
			// System.err.printf("必須選擇正確的性別選項: %s|%s|%s\n", MALE, FEMALE, OTHERS);//for
			// developers, testers, admins, not for users
			String msg = String.format("必須選擇正確的性別選項: %s|%s|%s\n", MALE, FEMALE, OTHERS);
			throw new AILMDataInvalidException(msg);
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address != null) {
			this.address = address.trim();
		} else {
			this.address = "";
		}
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "[account=" + account + ", 密碼=" + password + ",id=" + id + ",\n email="
				+ email + ", 手機=" + phone + ", 姓名=" + name + ", 生日=" + birthday + ", 性別=" + gender + ",\n 地址=" + address
				+ ", 是否訂閱=" + subscribed + ", 年齡=" + getAge() + "歲]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		member other = (member) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		return true;
	}

}
