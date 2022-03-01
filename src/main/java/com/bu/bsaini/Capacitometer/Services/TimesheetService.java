package com.bu.bsaini.Capacitometer.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bu.bsaini.Capacitometer.Dao.TimesheetRepo;
import com.bu.bsaini.Capacitometer.Models.Timesheet;

@Service
public class TimesheetService {

	@Autowired
	TimesheetRepo timesheetRepo;
	
	public void save(Timesheet timesheet) {
		timesheetRepo.save(timesheet);
	}
	
	public List<Timesheet> hasUserCheckedIn(int memberId) {
		return timesheetRepo.checkIfUserIsAlreadyCheckedIn(memberId);
	}
	
	public List<Timesheet> getCheckInLogsByGymMember(int memberId) {
		return timesheetRepo.findByTimesheetGymMemberIdOrderByCheckInTimeDesc(memberId);
	}
	
	public Integer getCountOfCurrentlyCheckedInMembers() {
		return timesheetRepo.countByStatus(1);
	}
	
	public List<Timesheet> getCapacityLogsByDate(LocalDateTime from, LocalDateTime to) {
		return timesheetRepo.findCapacityLogsByDate(from, to);
	}
}
