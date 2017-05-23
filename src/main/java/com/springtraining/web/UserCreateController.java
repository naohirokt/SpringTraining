package com.springtraining.web;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.springtraining.common.CommonClass;
import com.springtraining.common.Const.DispMode;
import com.springtraining.form.UserCreateForm;
import com.springtraining.model.MSection;
import com.springtraining.model.MUser;
import com.springtraining.service.KbnchService;
import com.springtraining.service.SectionService;
import com.springtraining.service.UserService;
import com.springtraining.vallidation.GroupOrder;
import com.springtraining.vallidation.UserCreateValidator;

@Controller
@RequestMapping(value = "/create")
public class UserCreateController {

	@Autowired
	private UserService userService;

	@Autowired
	private KbnchService kbnchService;

	@Autowired
	private SectionService sectionService;

	@Autowired
	private UserCreateValidator validator;

	@InitBinder
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@ModelAttribute("userCreateForm")
	public UserCreateForm initForm() {
		UserCreateForm form = new UserCreateForm();
		return form;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String userCreate(Model model, @ModelAttribute("userCreateForm") UserCreateForm form) {
		System.out.println("userCreate");
		setSelectBox(form);
		model.addAttribute("userCreateForm", form);
		model.addAttribute("dispMode", DispMode.INPUT.getValue());
		model.addAttribute("url", "confirm");
		return "userCreate";
	}

	@RequestMapping(value="/confirm", params="confirm", method=RequestMethod.POST)
	public String userCreateConfirm(Model model,
			@Validated(GroupOrder.class) @ModelAttribute("userCreateForm") UserCreateForm form, BindingResult result) {

		setSelectBox(form);
		model.addAttribute("userCreateForm", form);
		model.addAttribute("dispMode", DispMode.INPUT.getValue());
		model.addAttribute("url", "confirm");

		if (result.hasErrors()) {
			return "userCreate";
		}

		model.addAttribute("dispMode", DispMode.CONFIRM.getValue());
		model.addAttribute("url", "complete");
		System.out.println("userCreateConfirm");
		return "userCreate";
	}

	@RequestMapping(value="/complete", params="complete", method=RequestMethod.POST)
	public String userCreateComplete(@ModelAttribute("userCreateForm") UserCreateForm form, Model model) {
		System.out.println("userCreateComplete");
		insertMUser(form);
		setSelectBox(form);
		model.addAttribute("dispMode", DispMode.COMPLETE.getValue());
		return "userCreate";
	}

	private void setSelectBox(UserCreateForm form) {
		form.setYearList(CommonClass.getYearList());
		form.setMonthList(CommonClass.getMonthList());
		form.setDayList(CommonClass.getDayList());
		form.setAuthMap(kbnchService.getKbnchMap("AUTH"));
		form.setSectionMap(sectionService.getSectionMap());
		form.setSexMap(kbnchService.getKbnchMap("SEX"));
	}

	private void insertMUser(UserCreateForm form) {

		System.out.println(form.getUserId());
		MUser muser = new MUser();
		muser.setUserId(form.getUserId());
		muser.setPassword(form.getPassword());
		muser.setAuth(new BigDecimal(form.getAuth()));
		muser.setName(form.getName());

		MSection msection = new MSection();
		msection.setSectionId(form.getSectionId());
		muser.setMSection(msection);
		try {
			String dateStr =
					form.getBirthdayYear()
					+ "/"
					+ form.getBirthdayMonth()
					+ "/"
					+ form.getBirthdayDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date formatDate;
			formatDate = sdf.parse(dateStr);
			muser.setBirthday(formatDate);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		muser.setSex(form.getSex());
		muser.setAddress(form.getAddress());
		muser.setMailAddress(form.getMailAddress());
		muser.setQualify(form.getQualify());
		muser.setCreateUser(form.getUserId());
		muser.setCreateDate(new Timestamp(System.currentTimeMillis()));
		muser.setUpdateUser(form.getUserId());
		muser.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		muser.setInvalidFlg("0");
		userService.save(muser);
	}
}
