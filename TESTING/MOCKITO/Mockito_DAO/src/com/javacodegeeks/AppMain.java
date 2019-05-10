package com.javacodegeeks;

import java.sql.SQLException;

public class AppMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnection conn = new DBConnection();
		conn.getDBConnection();
	}

}
