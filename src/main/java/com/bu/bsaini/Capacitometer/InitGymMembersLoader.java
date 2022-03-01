package com.bu.bsaini.Capacitometer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bu.bsaini.Capacitometer.Models.GymMember;

public class InitGymMembersLoader extends InitDatabaseConnection implements Runnable {
	public static List<GymMember> gymMemberList = new ArrayList<GymMember>();
	
	@Override
	public void run() {
		Statement statement;
        try {
        	statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM GYMMEMBER WHERE STATUS = '1' ORDER BY ID ASC");
            while (rs.next()) {
            	GymMember gm = new GymMember();
            	gm.setId(rs.getInt(1));
        		gm.setFirstName(rs.getString(2));
        		gm.setLastName(rs.getString(3));
            	gymMemberList.add(gm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
