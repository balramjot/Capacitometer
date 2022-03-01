package com.bu.bsaini.Capacitometer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bu.bsaini.Capacitometer.Models.GymMember;
import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@SpringBootTest
public class CheckInTest {

	@Autowired
	TimesheetService timesheetService;
	
	@Test
	public void testCheckin() {
		GymMember gymMember = new GymMember();
		gymMember.setId(51);							// test user
		Timesheet checkIn = new Timesheet();
		checkIn.setGymMember(gymMember);
		checkIn.setStatus(1);
		timesheetService.save(checkIn);
		List<Timesheet> isUserCheckedIn = timesheetService.hasUserCheckedIn(checkIn.getGymMember().getId());
		assertEquals(isUserCheckedIn.isEmpty(), false);
	}
}
