package com.springtraining.vallidation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springtraining.form.UserListForm;

@Component
public class UserListValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return UserListForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object form, Errors errors) {
		UserListForm userListForm = (UserListForm)form;
		if (userListForm.getUserIds() == null) {
			errors.rejectValue("userIds", "userListForm.userNoSelect", "選択してください");
		}
	}

}
