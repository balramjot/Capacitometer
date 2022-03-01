package com.bu.bsaini.Capacitometer.Controllers.UIControllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.CapacityCalculator;

@Controller
public class RealTimeCapacityController extends PageLoadBaseController {
	
	@Autowired
    CapacityCalculator	capacityCalculator;
	
	@Override
	@GetMapping("/capacity")
	public String loadPage(Model formData) {
		formData.addAttribute("realTimeCapacity", capacityCalculator.processGymCapacity());
		formData.addAttribute("currentDateTime", LocalDateTime.now());
		return "capacity";
	}
}
