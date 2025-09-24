package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn;
	public static Connection getCon() {
		
		try {
			if(conn==null) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1434;databaseName = testDB;encrypt = true;trustServerCertificate = true";
				String username = "sa";
				String password = "12";
				conn = DriverManager.getConnection(url,username,password);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
