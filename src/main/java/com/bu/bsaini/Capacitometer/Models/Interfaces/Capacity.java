package com.bu.bsaini.Capacitometer.Models.Interfaces;


/**
 * Functional Interface to calculate real-time capacity
 * @author saini
 *
 */
public interface Capacity{
	
	/**
	 * This method calculate capacity of the gym
	 * @param maxCapacity, maximum capacity of the gym
	 * @param Member, number of currently checked in members
	 * @return, calculated capacity
	 */
	public int computeCapacity(int maxCapacity, Integer Member);
}
