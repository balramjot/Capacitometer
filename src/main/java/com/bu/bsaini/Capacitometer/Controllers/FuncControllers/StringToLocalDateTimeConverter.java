package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTimeConverter {

	private String format = "yyyy-MM-dd HH:mm:ss";
	private String date;
	
	public StringToLocalDateTimeConverter(String date) {
		this.date = date.concat(" 00:00:00");
	}
	
	public LocalDateTime convertStringToDateTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(this.format);
		return LocalDateTime.parse(date, dateTimeFormatter);
	}
}
