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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springtraining.common.CommonClass;
import com.springtraining.common.Const.DispMode;
import com.springtraining.form.UserCreateForm;
import com.springtraining.form.UserListForm;
import com.springtraining.model.MSection;
import com.springtraining.model.MUser;
import com.springtraining.service.KbnchService;
import com.springtraining.service.SectionService;
import com.springtraining.service.UserService;
import com.springtraining.vallidation.GroupOrder;

@Controller
@RequestMapping(value = "/update")
public class UserUpdateController {

	@Autowired
	private UserService userService;

	@Autowired
	private KbnchService kbnchService;

	@Autowired
	private SectionService sectionService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String update(Model model, @ModelAttribute UserListForm form, @ModelAttribute UserCreateForm createForm) {
		System.out.println("update");
		System.out.println(createForm.getUserId());

		if (createForm.getUserId() == null || "".equals(createForm.getUserId())) {
			MUser user = userService.getUser(form.getUserIds()[0]);
			createForm.setUserId(user.getUserId());
			createForm.setAddress(user.getAddress());
			createForm.setAuth(user.getAuth().intValue());
			createForm.setBirthdayYear(ymdFormat(user.getBirthday(), "yyyy"));
			createForm.setBirthdayMonth(ymdFormat(user.getBirthday(), "M"));
			createForm.setBirthdayDay(ymdFormat(user.getBirthday(), "d"));
			createForm.setMailAddress(user.getAddress());
			createForm.setName(user.getName());
			createForm.setPassword(user.getPassword());
			createForm.setQualify(user.getQualify());
			createForm.setSectionId(user.getMSection().getSectionId());
			createForm.setSex(user.getSex());
			setSelectBox(createForm);
		}
		model.addAttribute("userCreateForm", createForm);
		model.addAttribute("dispMode", DispMode.INPUT.getValue());
		model.addAttribute("url", "confirm");
		return "userUpdate";
	}

	@RequestMapping(value = "/confirm", params = "confirm", method = RequestMethod.POST)
	public String userUpdateConfirm(Model model, @Validated(GroupOrder.class) @ModelAttribute("userCreateForm") UserCreateForm form,
			BindingResult result) {

		setSelectBox(form);
		model.addAttribute("userCreateForm", form);

		if (result.hasErrors()) {
			System.out.println("error");
			model.addAttribute("dispMode", DispMode.INPUT.getValue());
			model.addAttribute("url", "confirm");
			return "userUpdate";
		}

		model.addAttribute("dispMode", DispMode.CONFIRM.getValue());
		model.addAttribute("url", "complete");
		System.out.println("userUpdateConfirm");
		return "userUpdate";
	}

	@RequestMapping(value = "/complete", params = "complete", method = RequestMethod.POST)
	public String userUpdateComplete(@ModelAttribute("userCreateForm") UserCreateForm form, Model model) {
		System.out.println("userUpdateComplete");
		System.out.println(form.getUserId());
		insertMUser(form);
		setSelectBox(form);
		model.addAttribute("dispMode", DispMode.COMPLETE.getValue());
		return "userUpdate";
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

		MUser muser = new MUser();
		muser.setUserId(form.getUserId());
		muser.setPassword(form.getPassword());
		muser.setAuth(new BigDecimal(form.getAuth()));
		muser.setName(form.getName());

		MSection msection = new MSection();
		msection.setSectionId(form.getSectionId());
		muser.setMSection(msection);
		try {
			String dateStr = form.getBirthdayYear()
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

	private String ymdFormat(Date value, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(value);
	}
}
