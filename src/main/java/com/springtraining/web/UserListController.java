package com.springtraining.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springtraining.form.UserListForm;
import com.springtraining.model.MUser;
import com.springtraining.service.UserService;
import com.springtraining.vallidation.GroupOrder;
import com.springtraining.vallidation.UserListValidator;

@Controller
public class UserListController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserListValidator validator;

	@InitBinder
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(Model model) {
		System.out.println("userList");
		List<MUser> userList = userService.getUserAll();
		if (userList.size() > 0) {
			UserListForm ulf = new UserListForm();
			model.addAttribute("userListForm", ulf);
			model.addAttribute("userList", userList);
			return "userList";
		}
		return "top";
	}

	@RequestMapping(value = "/userList", params = "create", method = RequestMethod.POST)
	public String create(Model model) {
		System.out.println("create");
		return "redirect:/create";
	}

	@RequestMapping(value = "/userList", params = "update", method = RequestMethod.POST)
	public String update(Model model, @Validated(GroupOrder.class) @ModelAttribute("userListForm") UserListForm form,
			RedirectAttributes attributes, BindingResult result) {
		System.out.println("updateCheck");
//		if (form.getUserIds() == null) {
//			return "redirect:/userList";
//		}
		if (result.hasErrors()) {
			return "redirect:/userList";
		}
		System.out.println("update");
		attributes.addFlashAttribute("userListForm", form);
		return "redirect:/update";
	}

	@RequestMapping(value = "/userList", params = "delete", method = RequestMethod.POST)
	public String delete(Model model, @Validated(GroupOrder.class) @ModelAttribute("userListForm") UserListForm form,
			RedirectAttributes attributes, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/userList";
		}
		System.out.println("delete");
		attributes.addFlashAttribute("userListForm", form);
		return "redirect:/delete";
	}

	@RequestMapping(value = "/userList/back", method = RequestMethod.GET)
	public String back(Model model) {
		return "redirect:/top";
	}

	@RequestMapping(value = "/edit", params = "logout", method = RequestMethod.POST)
	public String logout(Model model) {
		System.out.println("userlist.logout");
		return "redirect:/";
	}
}
