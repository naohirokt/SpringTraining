package com.springtraining.common;

public class Const {
	public static final String ATTENDANCE_TYPE_SHUKIN = "0";

	public static final String ATTENDANCE_TYPE_TAIKIN = "1";

	public enum WeekName {
		SUNDAY(1, "日"),
		MONDAY(2, "月"),
		TUESDAY(3, "火"),
		WEDNESDAY(4, "水"),
		THURSDAY(5, "木"),
		FRIDAY(6, "金"),
		SATURDAY(7, "土");

		private int value;

		private String name;

		WeekName(int value, String name) {
			this.value = value;
			this.name= name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String getName(int value) {
			for (WeekName weekname : WeekName.values()) {
				if (weekname.getValue() == value) {
					return weekname.getName();
				}
			}
			return "";
		}
	}

	public enum DispMode {
		INPUT("0", "入力"),
		CONFIRM("1", "確認"),
		COMPLETE("2", "完了");

		private String value;

		private String mesho;

		DispMode(String value, String mesho) {
			this.value = value;
			this.mesho = mesho;
		}

		public String getValue() {
			return this.value;
		}

		public String getMesho() {
			return this.mesho;
		}
	}
}
