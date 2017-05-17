package com.springtraining.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public static String ymdFormat(Date value, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(value);
	}
}
