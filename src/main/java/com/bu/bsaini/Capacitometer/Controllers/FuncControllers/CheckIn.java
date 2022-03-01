package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@Controller
public class CheckIn{
	
	@Autowired
	TimesheetService timesheetService;
	
	private Display displayController = new Display();
	
	public void doCheckIn(Timesheet checkIn, RedirectAttributes redirectAttributes) {
		String output;
		List<Timesheet> isUserCheckedIn = timesheetService.hasUserCheckedIn(checkIn.getGymMember().getId());
		if(!isUserCheckedIn.isEmpty()) {
			DateFormatter dateFormatController = new DateFormatter(isUserCheckedIn.get(0).getCheckInTime());
			output = this.displayController.output(isUserCheckedIn.get(0).getGymMember().getFirstName(), " already checked in at ", dateFormatController.getformattedDate());
			redirectAttributes.addFlashAttribute("message", output);
			redirectAttributes.addFlashAttribute("swapClass", "alert-danger");
		} else {
			checkIn.setStatus(1);
			timesheetService.save(checkIn);
			output = this.displayController.output("Welcome ", checkIn.getGymMember().getFirstName(), "!!!. You all set. Enjoy your workout !!!");
			redirectAttributes.addFlashAttribute("message", output);
			redirectAttributes.addFlashAttribute("swapClass", "alert-success");
		}
	}
}
