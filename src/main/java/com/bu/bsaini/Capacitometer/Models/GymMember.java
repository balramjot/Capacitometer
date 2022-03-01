package com.bu.bsaini.Capacitometer.Models;

import java.util.HashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Base class - GymMember that includes class variables
 * for creating a gym member
 * @author saini
 *
 */
@Entity
@Table(name="gymmember")
public class GymMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Basic
	@NotNull
	private String firstName;
	private String lastName;
	@Column(columnDefinition = "boolean default true")
	private Boolean status = true;
	@Transient
	private HashMap<Integer, Timesheet> timesheetMap;
	public GymMember() { 
	}
	
	public GymMember(int id, String firstName, String lastName, Boolean status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getStringValueOfId() {
		return String.valueOf(id);
	}

	public HashMap<Integer, Timesheet> getTimesheetMap() {
		return timesheetMap;
	}

	public void setTimesheetMap(HashMap<Integer, Timesheet> timesheetMap) {
		this.timesheetMap = timesheetMap;
	}
	
}
