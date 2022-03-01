package com.bu.bsaini.Capacitometer.Models;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Base class to set timesheet values
 * which means to track gym members check-in and
 * check-out times
 * @author saini
 *
 */
@Entity
@Table(name="timesheet")
public class Timesheet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	@Column
	private LocalDateTime checkInTime;
	@UpdateTimestamp
	@Column
	private LocalDateTime checkOutTime;
	@Basic
	private int status;
	private String totalDuration;
	@CreationTimestamp
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdOn;
	@NotNull
	@ManyToOne
	@JoinColumn(name="member_id")
	private GymMember gymMember;
	@Transient
	private Long count;
	@Transient
	private String month;
	@Transient
	private int year;
	
	public Timesheet() {
	}

	public Timesheet(int id, int memberId, LocalDateTime checkInTime, LocalDateTime checkOutTime, LocalDateTime createdOn, int status, GymMember gymMember) {
		this.id = id;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.createdOn = createdOn;
		this.status = status;
		this.gymMember = gymMember;
	}
	
	public Timesheet(Long count, String month, int year) {
		this.count = count;
		this.month = month;
		this .year = year;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(String totalDuration) {
		this.totalDuration = totalDuration;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public GymMember getGymMember() {
		return gymMember;
	}
	public void setGymMember(GymMember gymMember) {
		this.gymMember = gymMember;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
