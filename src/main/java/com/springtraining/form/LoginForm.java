package com.springtraining.form;

import org.hibernate.validator.constraints.NotEmpty;

import com.springtraining.vallidation.GroupOrder1;

public class LoginForm {

	@NotEmpty(groups = { GroupOrder1.class }, message = "ユーザIDを入力してください。")
//	@Size(min = 4, max = 8, groups = { GroupOrder2.class }, message = "ユーザIDは{min}文字以上{max}文字以下です。")
//	@Pattern(regexp = "[a-zA-Z0-9]*", groups = { GroupOrder2.class }, message = "ユーザIDは英数である必要があります。")
	private String userId;

	@NotEmpty(groups = { GroupOrder1.class }, message = "パスワードを入力してください。")
//	@Size(min = 8, max = 16, groups = { GroupOrder2.class }, message = "パスワードは{min}文字以上{max}文字以下です。")
//	@Pattern(regexp = "[a-zA-Z0-9]*", groups = { GroupOrder2.class }, message = "パスワードは英数である必要があります。")
	private String loginPassword;

	private String loginUserName;

	private String loginUserDepartmentName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getLoginUserDepartmentName() {
		return loginUserDepartmentName;
	}

	public void setLoginUserDepartmentName(String loginUserDepartmentName) {
		this.loginUserDepartmentName = loginUserDepartmentName;
	}

}