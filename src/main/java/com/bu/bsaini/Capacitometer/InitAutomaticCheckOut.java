package com.bu.bsaini.Capacitometer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.bu.bsaini.Capacitometer.Configurations.LoadConfigurations;
import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.DurationCalculator;
import com.bu.bsaini.Capacitometer.Exceptions.CustomException;

public class InitAutomaticCheckOut extends InitDatabaseConnection implements Runnable {

	@Override
	public void run() {
		Statement statement;
	    try {
	    	statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	        ResultSet rs = statement.executeQuery("SELECT id, status, checkOutTime, totalDuration, checkInTime FROM TIMESHEET WHERE STATUS = '1' AND TIMESTAMPDIFF(HOUR, CHECKINTIME, NOW()) > " + getAutoCheckOutTime());
	        while (rs.next()) {
	        	DurationCalculator durationCalculator = new DurationCalculator(rs.getTimestamp("CHECKINTIME").toLocalDateTime(), LocalDateTime.now());
	        	rs.updateInt("STATUS", 2);
	        	rs.updateTimestamp("CHECKOUTTIME", Timestamp.valueOf(LocalDateTime.now()));
	        	rs.updateString("TOTALDURATION", durationCalculator.calculateDuration());
	        	rs.updateRow();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	private Integer getAutoCheckOutTime() {
		Integer result;
		try {
			result = LoadConfigurations.configuration.getAutoCheckOutSetting().getAutoCheckOutTime();
		} catch (NumberFormatException e) {
			throw new CustomException("Auto checkOut time will only be an integer");
		}
		return result;
	}
}
