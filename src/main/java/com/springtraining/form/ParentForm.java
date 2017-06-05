package com.springtraining.form;

import java.util.List;

public class ParentForm {

	private String month;

	private List<String> monthList;

	private List<TopForm> topFormList;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<String> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<String> monthList) {
		this.monthList = monthList;
	}

	public List<TopForm> getTopFormList() {
		return topFormList;
	}

	public void setTopFormList(List<TopForm> topFormList) {
		this.topFormList = topFormList;
	}

}