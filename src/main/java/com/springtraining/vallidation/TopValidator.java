package com.springtraining.vallidation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springtraining.form.LoginForm;

@Component
public class TopValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return LoginForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object form, Errors errors) {
		LoginForm loginForm = (LoginForm)form;
		loginForm.getUserId();
//		if (LoginForm.getUserIds() == null) {
//			errors.rejectValue("userIds", "userListForm.userNoSelect", "選択してください");
//		}
	}

}
