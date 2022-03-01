package com.bu.bsaini.Capacitometer.Controllers.UIControllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bu.bsaini.Capacitometer.Configurations.LoadConfigurations;

@ControllerAdvice
public class GlobalController extends PageLoadBaseController {
	
	@Override
	@ModelAttribute("applicationConfiguration")
	public String loadPage(Model formData) {
		formData.addAttribute("applicationConfiguration", LoadConfigurations.configuration);
		return "";
	}
	
}
