package com.springtraining.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springtraining.common.CommonClass;
import com.springtraining.form.UserCreateForm;
import com.springtraining.form.UserListForm;
import com.springtraining.model.MUser;
import com.springtraining.service.KbnchService;
import com.springtraining.service.SectionService;
import com.springtraining.service.UserService;

@Controller
public class UserDeleteController {

	@Autowired
	private UserService userService;

	@Autowired
	private SectionService sectionService;

	@Autowired
	private KbnchService kbnchService;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, @ModelAttribute UserListForm form) {
		System.out.println("delete");
		System.out.println(form.getUserIds()[0]);

		UserCreateForm urf = new UserCreateForm();
		MUser user = userService.getUser(form.getUserIds()[0]);
		urf.setUserId(user.getUserId());
		urf.setAddress(user.getAddress());
		urf.setAuth(user.getAuth().intValue());
		urf.setBirthdayYear(CommonClass.ymdFormat(user.getBirthday(), "yyyy"));
		urf.setBirthdayMonth(CommonClass.ymdFormat(user.getBirthday(), "M"));
		urf.setBirthdayDay(CommonClass.ymdFormat(user.getBirthday(), "d"));
		urf.setMailAddress(user.getAddress());
		urf.setName(user.getName());
		urf.setPassword(user.getPassword());
		urf.setQualify(user.getQualify());
		urf.setSectionId(user.getMSection().getSectionId());
		urf.setSex(user.getSex());
		urf.setAuthDispName(getKbnchMesho("AUTH", user.getAuth()));
		urf.setSectionDispName(getSectionName(user.getMSection().getSectionId()));
		urf.setSexDispName(getKbnchMesho("SEX", user.getSex()));

		model.addAttribute("userCreateForm", urf);
		model.addAttribute("dispMode", "0");
		return "userDelete";
	}

	@RequestMapping(value = "/delete/complete", params = "deleteComplete", method = RequestMethod.POST)
	public String userDeleteComplete(@ModelAttribute("userCreateForm") UserCreateForm form, Model model) {
		System.out.println("deleteComplete");
		userService.delete(form.getUserId());
		model.addAttribute("dispMode", "1");
		return "userDelete";
	}

	private String getKbnchMesho(String kbnch, Object kbnchCd) {
		return kbnchService.getKbnchMap(kbnch).get(String.valueOf(kbnchCd));
	}

	private String getSectionName(String sectionId) {
		return sectionService.getSection(sectionId).getSectionName();
	}
}
