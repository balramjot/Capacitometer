package com.bu.bsaini.Capacitometer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bu.bsaini.Capacitometer.Models.MaxGymCapacity;

public class InitGymMaxCapacityLoader extends InitDatabaseConnection implements Runnable {
	public static MaxGymCapacity gymMaxCapacity = new MaxGymCapacity();
	
	@Override
	public void run() {
		Statement statement;
        try {
        	statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM GYMMAXCAPACITY");
            while (rs.next()) {
            	gymMaxCapacity.setId(rs.getInt(1));
            	gymMaxCapacity.setCapacity(rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
