package com.springtraining.form;

import java.util.List;

public class KintaiListForm {

	/** 部署ID */
	private String sectionId;

	/** ユーザー名 */
	private String userName;

	/** 労働時間 */
	private String workHours;

	/** 残業時間 */
	private String overTime;

	/** 労働日数 */
	private String workingDay;

	/** 遅刻日数 */
	private String lateDays;

	/** 早退日数 */
	private String leaveEarlyDays;

	/** 勤怠リスト */
	private List<KintaiListForm> kintaiListFormList;

	/**
	 * 部署IDを取得します。
	 * @return 部署ID
	 */
	public String getSectionId() {
		return sectionId;
	}

	/**
	 * 部署IDを設定します。
	 * @param sectionId
	 */
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * ユーザーIDを取得します。
	 * @return ユーザーID
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * ユーザーIDを設定します。
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 労働時間を取得します。
	 * @return 労働時間
	 */
	public String getWorkHours() {
		return workHours;
	}

	/**
	 * 労働時間を設定します。
	 * @param workHours
	 */
	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	/**
	 * 残業時間を取得します。
	 * @return 残業時間
	 */
	public String getOverTime() {
		return overTime;
	}

	/**
	 * 残業時間を設定します。
	 * @param overTime 残業時間
	 */
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	/**
	 * 労働日を取得します。
	 * @return 労働日
	 */
	public String getWorkingDay() {
		return workingDay;
	}

	/**
	 * 労働日を設定します。
	 * @param workingDay 労働日
	 */
	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

	/**
	 * 遅刻日数を取得します。
	 * @return 遅刻日数
	 */
	public String getLateDays() {
		return lateDays;
	}

	/**
	 * 遅刻日数を設定します。
	 * @param lateDays 遅刻日数
	 */
	public void setLateDays(String lateDays) {
		this.lateDays = lateDays;
	}

	/**
	 * 早退日数を取得します。
	 * @return 早退日数
	 */
	public String getLeaveEarlyDays() {
		return leaveEarlyDays;
	}

	/**
	 * 早退日数を設定します。
	 * @param leaveEarlyDays 早退日数
	 */
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