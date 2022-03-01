package com.bu.bsaini.Capacitometer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@SpringBootTest
public class CheckInLogsTest {

	@Autowired
	TimesheetService timesheetService;
	
	@Test
	public void testCheckinLogs() {
		List<Timesheet> timesheetList = timesheetService.getCheckInLogsByGymMember(1);
		assertTrue(timesheetList.size() > 0);
	}
}
