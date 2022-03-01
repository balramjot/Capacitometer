package com.bu.bsaini.Capacitometer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitDatabaseConnection implements Runnable {
	
	Connection connection;

    private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mariadb://localhost:3306/capacitometerdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public InitDatabaseConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void run() {
		try {
			if(connection.isValid(0))
				System.out.println("Connection is successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
