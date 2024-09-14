package com.ailaptopmall.service;

import java.sql.*;
import java.util.ResourceBundle;
import com.ailaptopmall.exception.AILMException;

class MySQLConnection {
	private static final String DRIVER; // = "com.mysql.cj.jdbc.Driver";
	private static final String URL; // ="jdbc:mysql://localhost:3306/ailm";
	private static final String USER_ID; // = "root";
	private static final String DB_PWD;// = "1234";

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("com.ailaptopmall.service.mysql");

		DRIVER = bundle.getString("jdbc.driver");
		URL = bundle.getString("jdbc.url");
		USER_ID = bundle.getString("jdbc.userid");
		DB_PWD = bundle.getString("jdbc.pwd");
	}

	static Connection getConnection() throws AILMException {
		try {
			Class.forName(DRIVER);// 1.載入Driver類別
			try {
				Connection connection = DriverManager.getConnection(URL, USER_ID, DB_PWD);// 2.建立連線
				return connection;
			} catch (SQLException e) {
				throw new AILMException("建立連線失敗", e); // 通知前端

			}

		} catch (ClassNotFoundException e) {
			throw new AILMException("載入Driver類別失敗", e); // 通知前端
		}

	}
}
