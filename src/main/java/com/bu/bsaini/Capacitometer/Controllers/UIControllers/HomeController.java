package com.bu.bsaini.Capacitometer.Controllers.UIControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends PageLoadBaseController {
	
	@Override
	@GetMapping("/")
	public String loadPage(Model formData) {
		return "index";
	}
}
