package com.javacodegeeks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	 
	  private Connection dbConnection;

	  public void getDBConnection() throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
	    dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/foxm_university?useUnicode=true&serverTimezone=UTC", "mysql", "mysql");
	  }
	 
	  public int executeQuery(String query) throws ClassNotFoundException, SQLException {
	    return dbConnection.createStatement().executeUpdate(query);
	  }
	}