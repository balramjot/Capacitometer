package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bu.bsaini.Capacitometer.Models.Timesheet;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@Controller
public class CapacityLogs {
	
	private List<Timesheet> capacityLogsList = new ArrayList<Timesheet>();
	private StringToLocalDateTimeConverter fromDate;
	private StringToLocalDateTimeConverter toDate;
	
	@Autowired
	TimesheetService timesheetService;
	
	public List<Timesheet> getCapacityLogsByDate(LocalDateTime from, LocalDateTime to) {
		return timesheetService.getCapacityLogsByDate(from, to);
	}
	
	private void getCapacityLogs(String from, String to) {
		this.fromDate = new StringToLocalDateTimeConverter(from);
		this.toDate = new StringToLocalDateTimeConverter(to);
		this.capacityLogsList = getCapacityLogsByDate(this.fromDate.convertStringToDateTime(), this.toDate.convertStringToDateTime());
	}
	
	public boolean hasCapacityLogsList(String from, String to) {
		getCapacityLogs(from, to);
		return capacityLogsList.isEmpty();
	}
	
	public String[] getGraphLabels() {
		String[] chartLabels = new String[this.capacityLogsList.size()];
		int i = 0;
		for(Timesheet logsList: this.capacityLogsList) {
			chartLabels[i] = logsList.getMonth();
			i++;
		}
		return chartLabels;
	}
	
	public int[] getGraphValues() {
		int[] chartValues = new int[this.capacityLogsList.size()];
		int i = 0;
		for(Timesheet logsList: this.capacityLogsList) {
			chartValues[i] = logsList.getCount().intValue();
			i++;
		}
		return chartValues;
	}
	
	public Month getMonthFromDate() {
		return this.fromDate.convertStringToDateTime().getMonth();
	}
	
	public int getYearFromDate() {
		return this.fromDate.convertStringToDateTime().getYear();
	}
	
	public Month getMonthToDate() {
		return this.toDate.convertStringToDateTime().getMonth();
	}
	
	public int getYearToDate() {
		return this.toDate.convertStringToDateTime().getYear();
	}
}
