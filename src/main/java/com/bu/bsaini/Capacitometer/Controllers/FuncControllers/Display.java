package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import com.bu.bsaini.Capacitometer.Models.Abstracts.DisplayFactory;

public class Display extends DisplayFactory {

	@Override
	public String output(String... s) {
		String out = "";
		if(s.length > 0 || s != null || s.equals("")) {
			for(String ss: s) {
				out += ss;
			}
		}
		return out;
	}

}
