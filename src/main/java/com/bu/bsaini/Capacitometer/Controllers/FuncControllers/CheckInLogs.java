package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@Controller
public class CheckInLogs {
	
	@Autowired
	TimesheetService timesheetService;
	
	public List<Timesheet> getCheckInLogs(int memberId) {
		return timesheetService.getCheckInLogsByGymMember(memberId);
	}
}
