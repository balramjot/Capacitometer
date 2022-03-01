package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@Controller
public class CheckOut {

	@Autowired
	TimesheetService timesheetService;
	
	private Display displayController = new Display();
	
	public void doCheckOut(Timesheet checkOut, RedirectAttributes redirectAttributes) {
		String output;
		List<Timesheet> isUserCheckedOut = timesheetService.hasUserCheckedIn(checkOut.getGymMember().getId());
		if(isUserCheckedOut.isEmpty()) {
			output = this.displayController.output("Opps..!!!! You haven't checked in yet.");
			redirectAttributes.addFlashAttribute("message", output);
			redirectAttributes.addFlashAttribute("swapClass", "alert-danger");
		} else {
			isUserCheckedOut.get(0).setStatus(2);
			DurationCalculator durationCalculator = new DurationCalculator(isUserCheckedOut.get(0).getCheckInTime(), LocalDateTime.now());
			isUserCheckedOut.get(0).setTotalDuration(durationCalculator.calculateDuration());
			timesheetService.save(isUserCheckedOut.get(0));
			output = this.displayController.output("Good Bye !!! ", checkOut.getGymMember().getFirstName(), "!!!. See you tomorrow.");
			redirectAttributes.addFlashAttribute("message", output);
			redirectAttributes.addFlashAttribute("swapClass", "alert-success");
		}
	}
}
