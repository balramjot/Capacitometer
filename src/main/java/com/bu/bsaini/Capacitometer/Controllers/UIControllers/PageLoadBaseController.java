package com.bu.bsaini.Capacitometer.Controllers.UIControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageLoadBaseController {
	
	public String loadPage(Model formData) {
		return "";
	}
	
	public String loadPage(@PathVariable("pathVariable") String pathVariable, Model formData) {
		return "";
	}
}
