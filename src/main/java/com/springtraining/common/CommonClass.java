package com.springtraining.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CommonClass {

	public static List<String> getDayList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 31; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}

	public static List<String> getYearList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1960; i <= 2000; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}

	public static List<String> getMonthList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}

	public static Date ymdStringToDate(String ymd, String hhmm) {

        String dateStr = ymd + " " + hhmm + ":00";

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			return null;
		}
	}

	public static String ymdFormat(Date value, String format) {
		if (value == null) {
			return "";
		}
		return new SimpleDateFormat(format).format(value);
	}

	public static String ymdFormatTimestamp(Timestamp value, String format) {
		if (value == null) {
			return "";
		}
		return new SimpleDateFormat(format).format(value);
	}

	public static List<Calendar> getCalendarList(Timestamp value) {
		int year = Integer.parseInt(ymdFormatTimestamp(value, "YYYY"));
		int month = Integer.parseInt(ymdFormatTimestamp(value, "MM"));
		int startDate = 1;
		return getCalendarList(year, month, startDate);
	}

	public static List<Calendar> getCalendarList(int year, int month, int startDate) {
		List<Calendar> dates = new ArrayList<Calendar>();
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.YEAR, year);
		instance.set(Calendar.MONTH, month);
		int lastDate = instance.getActualMaximum(Calendar.DATE);
		for (int date = startDate; date <= lastDate; date++) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, date, 0, 0, 0);
			dates.add(cal);
		}
		return dates;
	}

	public static String getDateDiff(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return "";
		}
		long diff = date1.getTime() - date2.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		return formatter.format(diff);
	}
}
