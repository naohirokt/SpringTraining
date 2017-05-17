package com.springtraining.vallidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springtraining.form.UserCreateForm;
import com.springtraining.repository.MUserRepository;

@Component
public class UserCreateValidator implements Validator {

	@Autowired
	private MUserRepository userRep;

	public boolean supports(Class<?> clazz) {
		return UserCreateForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object form, Errors errors) {
		UserCreateForm userCreateForm = (UserCreateForm)form;
		if (userRep.exists(userCreateForm.getUserId())) {
			errors.rejectValue("userId", "userCreateForm.userExists");
		}

	}

}
