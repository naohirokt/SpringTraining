package com.springtraining.form;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.springtraining.vallidation.GroupOrder1;
import com.springtraining.vallidation.GroupOrder2;

public class UserCreateForm {

	@NotEmpty(groups = { GroupOrder1.class }, message = "ユーザIDを入力してください。")
	@Pattern(regexp = "[a-zA-Z0-9]*", groups = { GroupOrder2.class }, message = "ユーザIDは英数である必要があります。")
	private String userId;

	@NotEmpty(groups = { GroupOrder1.class }, message = "パスワードを入力してください。")
	@Pattern(regexp = "[a-zA-Z0-9]*", groups = { GroupOrder2.class }, message = "ユーザIDは英数である必要があります。")
	private String password;

	@NotNull(groups = { GroupOrder1.class }, message = "権限を選択してください。")
	private int auth;

	@NotEmpty(groups = { GroupOrder1.class }, message = "部署を選択してください。")
	private String sectionId;

	@NotEmpty(groups = { GroupOrder1.class }, message = "名前を入力してください。")
	private String name;

	@NotEmpty(groups = { GroupOrder1.class }, message = "生年月日（年）を選択してください。")
	private String birthdayYear;

	@NotEmpty(groups = { GroupOrder1.class }, message = "生年月日（月）を選択してください。")
	private String birthdayMonth;

	@NotEmpty(groups = { GroupOrder1.class }, message = "生年月日（日）を選択してください。")
	private String birthdayDay;

	@NotEmpty(groups = { GroupOrder1.class }, message = "性別を選択してください。")
	private String sex;

	@NotEmpty(groups = { GroupOrder1.class }, message = "住所を入力してください。")
	private String address;

	@NotEmpty(groups = { GroupOrder1.class }, message = "メールアドレスを入力してください。")
	private String mailAddress;

	@NotEmpty(groups = { GroupOrder1.class }, message = "資格を入力してください。")
	private String qualify;

	private List<String> yearList;

	private List<String> monthList;

	private List<String> dayList;

	private Map<Object, String> authMap;

	private Map<String, String> sectionMap;

	private Map<Object, String> sexMap;

	private String authDispName;

	private String sectionDispName;

	private String sexDispName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(String birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	public String getBirthdayMonth() {
		return birthdayMonth;
	}

	public void setBirthdayMonth(String birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

	public String getBirthdayDay() {
		return birthdayDay;
	}

	public void setBirthdayDay(String birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getQualify() {
		return qualify;
	}

	public void setQualify(String qualify) {
		this.qualify = qualify;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public List<String> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<String> monthList) {
		this.monthList = monthList;
	}

	public List<String> getDayList() {
		return dayList;
	}

	public void setDayList(List<String> dayList) {
		this.dayList = dayList;
	}

	public Map<Object, String> getAuthMap() {
		return authMap;
	}

	public void setAuthMap(Map<Object, String> authMap) {
		this.authMap = authMap;
	}

	public Map<String, String> getSectionMap() {
		return sectionMap;
	}

	public void setSectionMap(Map<String, String> sectionMap) {
		this.sectionMap = sectionMap;
	}

	public Map<Object, String> getSexMap() {
		return sexMap;
	}

	public void setSexMap(Map<Object, String> sexMap) {
		this.sexMap = sexMap;
	}

	public String getAuthDispName() {
		return authDispName;
	}

	public void setAuthDispName(String authDispName) {
		this.authDispName = authDispName;
	}

	public String getSectionDispName() {
		return sectionDispName;
	}

	public void setSectionDispName(String sectionDispName) {
		this.sectionDispName = sectionDispName;
	}

	public String getSexDispName() {
		return sexDispName;
	}

	public void setSexDispName(String sexDispName) {
		this.sexDispName = sexDispName;
	}
}