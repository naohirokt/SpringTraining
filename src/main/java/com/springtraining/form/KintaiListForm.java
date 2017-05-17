package com.springtraining.form;

import java.util.List;

public class KintaiListForm {

	private String sectionId;

	private String userName;

	private String workHours;

	private String overTime;

	private String workingDay;

	private String lateDays;

	private String leaveEarlyDays;

	private List<KintaiListForm> kintaiListFormList;

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
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

	public List<KintaiListForm> getKintaiListFormList() {
		return kintaiListFormList;
	}

	public void setKintaiListFormList(List<KintaiListForm> kintaiListFormList) {
		this.kintaiListFormList = kintaiListFormList;
	}
}