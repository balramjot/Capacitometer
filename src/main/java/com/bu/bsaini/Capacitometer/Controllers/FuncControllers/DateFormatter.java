package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

	private String format = "MMM d YYYY h:mm a";
	private LocalDateTime dateTime;
	
	public DateFormatter(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public DateFormatter(String format, LocalDateTime dateTime) {
		this.format = format;
		this.dateTime = dateTime;
	}
	
	public String getformattedDate() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(this.format);
		return dateTimeFormatter.format(this.dateTime);	
	}
}
