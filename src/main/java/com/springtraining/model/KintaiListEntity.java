package com.springtraining.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class KintaiListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	private String userName;

	private String workHours;

	private String overTime;

	private String workingDay;

	private String lateDays;

	private String leaveEarlyDays;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getWorkHours() {
		return workHours;
	}


	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}


	public String getOverTime() {
		return overTime;
	}


	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}


	public String getWorkingDay() {
		return workingDay;
	}


	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}


	public String getLateDays() {
		return lateDays;
	}


	public void setLateDays(String lateDays) {
		this.lateDays = lateDays;
	}


	public String getLeaveEarlyDays() {
		return leaveEarlyDays;
	}


	public void setLeaveEarlyDays(String leaveEarlyDays) {
		this.leaveEarlyDays = leaveEarlyDays;
	}
}