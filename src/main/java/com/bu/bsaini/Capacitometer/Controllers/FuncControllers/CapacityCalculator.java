package com.bu.bsaini.Capacitometer.Controllers.FuncControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bu.bsaini.Capacitometer.InitGymMaxCapacityLoader;
import com.bu.bsaini.Capacitometer.Exceptions.CustomException;
import com.bu.bsaini.Capacitometer.Models.Interfaces.Capacity;
import com.bu.bsaini.Capacitometer.Services.TimesheetService;

@Controller
public class CapacityCalculator {
	
	@Autowired
	TimesheetService timesheetService;
	
	public Integer getCountOfCurrentlyCheckedInMembers() {
		return timesheetService.getCountOfCurrentlyCheckedInMembers();
	}
	
	/**
	 * Functional interface to calculate gym capacity
	 */
	Capacity getGymCapacity = (maxCapacity, checkedInMember) -> {
		try {
			int capacityPercentage = (checkedInMember * 100)/maxCapacity;
			return capacityPercentage;
		} catch (ArithmeticException e) {
			throw new CustomException("Error while calculating capacity");
		}
	};
	
	
	/**
	 * This method uses functional interface to compute gym capacity
	 */
	public int processGymCapacity() {
		return getGymCapacity.computeCapacity(InitGymMaxCapacityLoader.gymMaxCapacity.getCapacity(), getCountOfCurrentlyCheckedInMembers());
	}
}
