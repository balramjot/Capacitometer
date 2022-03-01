package com.bu.bsaini.Capacitometer.Controllers.UIControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bu.bsaini.Capacitometer.InitGymMembersLoader;
import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.CheckIn;
import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.CheckOut;
import com.bu.bsaini.Capacitometer.Models.GymMember;
import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@Controller
public class ActionController extends PageLoadBaseController {
	
	@Autowired
	CheckIn checkInController;
	@Autowired
	CheckOut checkOutController;
	@Autowired
	TimesheetService timesheetService;
	
	@Override
	@GetMapping("/action/{pg}")
	public String loadPage(@PathVariable("pg") String pageTitle, Model formData) {
		List<GymMember> gymMemberList = InitGymMembersLoader.gymMemberList;
		Timesheet timesheet = new Timesheet();
		formData.addAttribute("pageTitle", pageTitle);
		formData.addAttribute("gymMembers", gymMemberList);
		formData.addAttribute("timesheet", timesheet);
		return "action";
	}
	
	@PostMapping("/action/checkIn")
	public String handleCheckInRequest(@ModelAttribute("timesheet") Timesheet checkIn, BindingResult result, RedirectAttributes redirectAttributes) {
		checkInController.doCheckIn(checkIn, redirectAttributes);
		return "redirect:/action/checkIn";
	}
	
	@PostMapping("/action/checkOut")
	public String handleCheckOutRequest(@ModelAttribute("timesheet") Timesheet checkOut, BindingResult result, RedirectAttributes redirectAttributes) {
		checkOutController.doCheckOut(checkOut, redirectAttributes);
		return "redirect:/action/checkOut";
	}
}
