package com.springtraining.common;

public class Const {
	public static final String ATTENDANCE_TYPE_SHUKIN = "0";

	public static final String ATTENDANCE_TYPE_TAIKIN = "1";

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
