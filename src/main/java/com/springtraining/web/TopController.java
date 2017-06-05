package com.springtraining.web;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springtraining.common.CommonClass;
import com.springtraining.common.Const;
import com.springtraining.form.LoginForm;
import com.springtraining.form.ParentForm;
import com.springtraining.form.TopForm;
import com.springtraining.model.Holiday;
import com.springtraining.model.TTime;
import com.springtraining.model.TTimePK;
import com.springtraining.service.HolidayService;
import com.springtraining.service.TimeService;

@Controller
@SessionAttributes(value="loginForm")
@RequestMapping(value="/top")
public class TopController {

	@Autowired
	private TimeService timeService;

	@Autowired
	private HolidayService holidayService;

	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model, LoginForm form, @ModelAttribute("parentForm") ParentForm parentForm) {
		System.out.println("topInit");
		String year = CommonClass.ymdFormatTimestamp(new Timestamp(System.currentTimeMillis()), "YYYY");
		String month = CommonClass.ymdFormatTimestamp(new Timestamp(System.currentTimeMillis()), "M");
		parentForm.setMonth(month);
		parentForm.setMonthList(CommonClass.getMonthList());
		parentForm.setTopFormList(getTopFormList(form.getUserId(), Integer.parseInt(year), Integer.parseInt(month)));
		model.addAttribute("parentForm", parentForm);
		return "top";
	}

	@RequestMapping(params="search", method=RequestMethod.POST)
	public String search(Model model, LoginForm form, @ModelAttribute("parentForm") ParentForm parentForm) {
		System.out.println("topSearch");
		String year = CommonClass.ymdFormatTimestamp(new Timestamp(System.currentTimeMillis()), "YYYY");
		String month = parentForm.getMonth();
		parentForm.setMonthList(CommonClass.getMonthList());
		parentForm.setTopFormList(getTopFormList(form.getUserId(), Integer.parseInt(year), Integer.parseInt(month)));
		model.addAttribute("parentForm", parentForm);
		return "top";
	}

	@RequestMapping(params="logout", method=RequestMethod.POST)
	public String logout() {
		System.out.println("logout");
		return "redirect:/";
	}

	@RequestMapping(params="create", method=RequestMethod.POST)
	public String create(LoginForm loginForm, @ModelAttribute("parentForm") ParentForm parentForm) {
		System.out.println("create");
		insertTTime(loginForm, parentForm);
		return "redirect:/top";
	}

	private void insertTTime(LoginForm form, ParentForm parentForm) {

		List<TopForm> topFormList = parentForm.getTopFormList();
		for (TopForm topForm : topFormList) {
			if (StringUtils.isEmpty(topForm.getStartTime())
					&& StringUtils.isEmpty(topForm.getEndTime())
					&& StringUtils.isEmpty(topForm.getBreakTime())
					&& StringUtils.isEmpty(topForm.getComment())) {
				System.out.println("continue");
				continue;
			}
			TTimePK pk = new TTimePK();
			pk.setUserId(form.getUserId());
			pk.setAttendanceDate(CommonClass.ymdStringToDate(topForm.getDay(), "00:00"));

			TTime ttime = new TTime();
			ttime.setId(pk);
			ttime.setStartDate(
					CommonClass.ymdStringToDate(topForm.getDay(), topForm.getStartTime()));
			ttime.setEndDate(
					CommonClass.ymdStringToDate(topForm.getDay(), topForm.getEndTime()));
			if (!StringUtils.isEmpty(topForm.getBreakTime())) {
				String[] value = topForm.getBreakTime().split(":");
				ttime.setBreakTime(new BigDecimal(Integer.parseInt(value[0]) * 60 + Integer.parseInt(value[1])));
			}
			ttime.setBiko(topForm.getComment());
			ttime.setCreateDate(new Timestamp(System.currentTimeMillis()));
			ttime.setCreateUser(form.getUserId());
			ttime.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			ttime.setUpdateUser(form.getUserId());
			ttime.setInvalidFlg("0");
			timeService.save(ttime);
		}
	}

	private List<TopForm> getTopFormList(String userId, int targetYear, int targetMonth) {
		List<TopForm> topFormList = new ArrayList<TopForm>();
		List<Calendar> calList = CommonClass.getCalendarList(targetYear, targetMonth, 1);
		for (Calendar cal : calList) {
			TopForm topForm = new TopForm();
			topForm.setDay(CommonClass.ymdFormat(cal.getTime(), "YYYY/MM/dd"));
			topForm.setWeek(Const.WeekName.getName(cal.get(Calendar.DAY_OF_WEEK)));

			Holiday holiday = holidayService.getTargetDay(cal.getTime());
			if (Const.WeekName.SUNDAY.getValue() == cal.get(Calendar.DAY_OF_WEEK)
					|| !StringUtils.isEmpty(holiday)) {
				topForm.setIsHoliday("1");
				if (!StringUtils.isEmpty(holiday)) {
					topForm.setComment(holiday.getHolidayName());
				}
			} else if (Const.WeekName.SATURDAY.getValue() == cal.get(Calendar.DAY_OF_WEEK)) {
				topForm.setIsSaturday("1");
			} else {
				topForm.setIsSaturday("0");
			}

			TTimePK key = new TTimePK();
			key.setUserId(userId);
			key.setAttendanceDate(cal.getTime());

			TTime time = timeService.getKey(key);

			if (!StringUtils.isEmpty(time)) {
				topForm.setStartTime(CommonClass.ymdFormat(time.getStartDate(), "HH:mm"));
				topForm.setEndTime(CommonClass.ymdFormat(time.getEndDate(), "HH:mm"));
				if (!StringUtils.isEmpty(time.getBreakTime())) {
					int hours = time.getBreakTime().intValue() / 60;
					int minutes = time.getBreakTime().intValue() % 60;
					topForm.setBreakTime(String.format("%02d", hours) + ":" + String.format("%02d", minutes));
				}
				topForm.setTotalTime(CommonClass.getDateDiff(time.getEndDate(), time.getStartDate()));
				topForm.setComment(time.getBiko());
			}
			topFormList.add(topForm);
		}
		return topFormList;
	}
}
