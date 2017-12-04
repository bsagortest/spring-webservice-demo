package com.rufaida.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    
    public Connection getConnection() {
    	Connection connection = null;
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@100.43.0.16:1521:oracle", "test","tess"); // Local
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return connection;
    }
}
