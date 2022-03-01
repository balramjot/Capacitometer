package com.bu.bsaini.Capacitometer.Controllers.UIControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.CapacityLogs;

@Controller
public class CapacityLogsController extends PageLoadBaseController {
	
	@Autowired
	CapacityLogs capacityLogs;
	
	@Override
	@GetMapping("/capacityLogs")
	public String loadPage(Model formData) {
		formData.addAttribute("isLogsEmpty", true);	
		return "capacity_logs";
	}
	
	@GetMapping("/capacityLogs/searchLogs")
	public String searchCapacityLogs(Model formData, @Param("from") String from, @Param("to") String to) {		
		formData.addAttribute("isLogsEmpty", capacityLogs.hasCapacityLogsList(from, to));		
		formData.addAttribute("chartLabels", capacityLogs.getGraphLabels());
		formData.addAttribute("chartValues", capacityLogs.getGraphValues());
		formData.addAttribute("startMonth", capacityLogs.getMonthFromDate());
		formData.addAttribute("startYear", capacityLogs.getYearFromDate());
		formData.addAttribute("endMonth", capacityLogs.getMonthToDate());
		formData.addAttribute("endYear", capacityLogs.getYearToDate());
		return "capacity_logs";
	}
}
