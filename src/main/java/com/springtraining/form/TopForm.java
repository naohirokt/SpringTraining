package com.springtraining.form;

public class TopForm {

	/** 日付 */
	private String day;

	/** 曜日 */
	private String week;

	/** 開始時間 */
	private String startTime;

	/** 終了時間 */
	private String endTime;

	/** 休憩時間 */
	private String breakTime;

	/** 労働時間 */
	private String totalTime;

	/** コメント */
	private String comment;

	/** 土曜日か */
	private String isSaturday;

	/** 祝日か */
	private String isHoliday;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIsSaturday() {
		return isSaturday;
	}

	public void setIsSaturday(String isSaturday) {
		this.isSaturday = isSaturday;
	}

	public String getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(String isHoliday) {
		this.isHoliday = isHoliday;
	}

}