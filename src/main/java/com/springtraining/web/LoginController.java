package com.springtraining.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springtraining.form.LoginForm;
import com.springtraining.model.MUser;
import com.springtraining.service.UserService;
import com.springtraining.vallidation.GroupOrder;

@Controller
@SessionAttributes(value="loginForm")
public class LoginController {

	@Autowired
	private UserService userService;

	@ModelAttribute(value="loginForm")
	LoginForm loginForm() {
		return new LoginForm();
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value="/login", method={ RequestMethod.POST, RequestMethod.GET })
	public String login(Model model, @Validated(GroupOrder.class) LoginForm loginForm,
			BindingResult result) {

		if (result.hasErrors()) {
			return "index";
		}

		MUser user = userService.getUser(loginForm.getUserId(), loginForm.getLoginPassword());

		if (!StringUtils.isEmpty(user)) {
			loginForm.setLoginUserName(user.getName());
			loginForm.setLoginUserDepartmentName(user.getMSection().getSectionName());
			loginForm.setLoginUserAuth(String.valueOf(user.getAuth()));
			model.addAttribute("loginForm", loginForm);
			return "redirect:/top";
		} else {
			return "index";
		}
	}
}