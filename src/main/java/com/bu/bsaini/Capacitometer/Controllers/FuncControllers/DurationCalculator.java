package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationCalculator {
	
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
	
	public DurationCalculator(LocalDateTime checkInTime, LocalDateTime checkOutTime) {
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}
	
	public String calculateDuration() {
		Duration duration = Duration.between(this.checkInTime, this.checkOutTime);
		int totalMinutes = Integer.valueOf((int) duration.toMinutes());
		int hours = totalMinutes / 60;
		int minutes = totalMinutes % 60;
		String totalDuration = null;

		if(hours >= 1 && hours <= 5) {
			totalDuration = hours + " hour " + minutes + " minutes";
		} else if(hours > 5) {
			totalDuration = "5 hour";
		} else {
			totalDuration = minutes + " minutes";
		}
		return totalDuration;
	}
}
