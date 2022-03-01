package com.bu.bsaini.Capacitometer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.DurationCalculator;
import com.bu.bsaini.Capacitometer.Models.GymMember;
import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@SpringBootTest
public class CheckOutTest {

	@Autowired
	TimesheetService timesheetService;
	
	@Test
	public void testCheckOut() {
		GymMember gymMember = new GymMember();
		gymMember.setId(51);					// test user
		List<Timesheet> isUserCheckedOut = timesheetService.hasUserCheckedIn(gymMember.getId());
		DurationCalculator durationCalculator = new DurationCalculator(isUserCheckedOut.get(0).getCheckInTime(), isUserCheckedOut.get(0).getCheckOutTime());
		isUserCheckedOut.get(0).setTotalDuration(durationCalculator.calculateDuration());
		isUserCheckedOut.get(0).setStatus(2);
		timesheetService.save(isUserCheckedOut.get(0));
		List<Timesheet> isUserCheckedOutList = timesheetService.hasUserCheckedIn(gymMember.getId());
		assertEquals(isUserCheckedOutList.isEmpty(), true);
	}
}
