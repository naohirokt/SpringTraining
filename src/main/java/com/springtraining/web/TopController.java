package com.springtraining.web;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springtraining.common.Const;
import com.springtraining.form.LoginForm;
import com.springtraining.model.TTime;
import com.springtraining.model.TTimePK;
import com.springtraining.repository.TTimeRepository;
import com.springtraining.service.UserService;

@Controller
@SessionAttributes(value = "loginForm")
@RequestMapping(value = "/top")
public class TopController {

	@Autowired
	private UserService userService;

	@Autowired
	private TTimeRepository timeRep;

	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model, LoginForm form) {
		return "top";
	}

	@RequestMapping(params="shukkin", method=RequestMethod.POST)
	public String shukkin(LoginForm loginForm, Model model) {
		System.out.println("shukkin");
		insertTTime(loginForm, true);
		return "top";
	}

	@RequestMapping(params="taikin", method=RequestMethod.POST)
	public String taikin(LoginForm loginForm) {
		System.out.println("taikin");
		insertTTime(loginForm, false);
		return "top";
	}

	@RequestMapping(params="logout", method=RequestMethod.POST)
	public String logout() {
		System.out.println("logout");
		return "redirect:/";
	}

	private void insertTTime(LoginForm form, boolean isShukin) {
		TTime ttime = new TTime();
		TTimePK pk = new TTimePK();
		pk.setUserId(form.getUserId());
		pk.setAttendanceDate(new Date(System.currentTimeMillis()));
		if (isShukin) {
			pk.setAttendanceType(Const.ATTENDANCE_TYPE_SHUKIN);
		} else {
			pk.setAttendanceType(Const.ATTENDANCE_TYPE_TAIKIN);
		}
		ttime.setId(pk);
		ttime.setCreateDate(new Timestamp(System.currentTimeMillis()));
		ttime.setCreateUser(form.getUserId());
		ttime.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		ttime.setUpdateUser(form.getUserId());
		ttime.setInvalidFlg("0");
		timeRep.save(ttime);
	}
}
