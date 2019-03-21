package com.example.businesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	private static final String CONN_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String CONN_URL = "jdbc:mysql://localhost/mydbtest?useUnicode=true&serverTimezone=UTC";
	private static final String CONN_USERNAME = "mysql";
	private static final String CONN_PASS = "mysql";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(CONN_DRIVER);
			connection = DriverManager.getConnection(CONN_URL, CONN_USERNAME, CONN_PASS);
			System.out.println("CONNECTION=OK");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("CONNECTION=FAIL");
		}

		return connection;
	}
}
