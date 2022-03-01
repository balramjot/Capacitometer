package com.bu.bsaini.Capacitometer.Models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Class containing member variables to handle
 * maximum gym capacity
 * @author saini
 *
 */
@Entity
@Table(name="gymmaxcapacity")
public class MaxGymCapacity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Basic
	@NotNull
	private int capacity;
	
	public MaxGymCapacity() {
	}
	
	public MaxGymCapacity(int id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
