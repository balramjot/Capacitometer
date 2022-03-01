package com.bu.bsaini.Capacitometer.Controllers.UIControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bu.bsaini.Capacitometer.InitGymMembersLoader;
import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.CheckInLogs;
import com.bu.bsaini.Capacitometer.Models.GymMember;
import com.bu.bsaini.Capacitometer.Models.Timesheet;

@Controller
public class CheckInLogsController extends PageLoadBaseController {
	
	@Autowired
	CheckInLogs checkInLogsController;
	
	@Override
	@GetMapping("/checkInLogs")
	public String loadPage(Model formData) {
		List<GymMember> gymMemberList = InitGymMembersLoader.gymMemberList;
		Timesheet timesheet = new Timesheet();
		timesheet.setId(1);
		List<Timesheet> checkInLogsList = checkInLogsController.getCheckInLogs(timesheet.getId());
		formData.addAttribute("gymMembers", gymMemberList);
		formData.addAttribute("timesheet", timesheet);
		formData.addAttribute("checkInLists", checkInLogsList);
		formData.addAttribute("selectedMemberName", gymMemberList.get(0).getFirstName().concat(" ").concat(gymMemberList.get(0).getLastName()));
		return "check_in_logs";
	}
	
	@GetMapping("/checkInLogs/searchLogs")
	public String searchCheckInLogs(Model formData, @Param("gymMember") GymMember gymMember) {
		List<GymMember> gymMemberList = InitGymMembersLoader.gymMemberList;
		List<Timesheet> checkInLogsList = checkInLogsController.getCheckInLogs(gymMember.getId());
		Timesheet timesheet = new Timesheet();
		timesheet.setGymMember(gymMember);
		formData.addAttribute("timesheet", timesheet);
		formData.addAttribute("gymMembers", gymMemberList);
		formData.addAttribute("checkInLists", checkInLogsList);
		formData.addAttribute("selectedMemberName", gymMember.getFirstName().concat(" ").concat(gymMember.getLastName()));
		return "check_in_logs";
	}
}
