package com.springtraining.form;

public class UserListForm {

//	@Size(min=1, message="エラー")
//	@NotEmpty(message="エラー")
	private String[] userIds;

	public String[] getUserIds() {
		return userIds;
	}

	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}
}