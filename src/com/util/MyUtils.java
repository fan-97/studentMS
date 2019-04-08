package com.util;

public class MyUtils {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param sname
	 * @return
	 */
	public static boolean isEmptyStr(String str) {
		if (str == null) {
			return true;
		}
		if (str.matches(" +")) {
			return true;
		}
		if ("null".equals(str)) {
			return true;
		}
		return false;
	}

	public static boolean checkBirthday(String birthday) {
		if (birthday.matches("^[12]\\d{3}-\\d{1,2}-\\d{1,2}$")) {
			return true;
		}
		return false;
	}
}
