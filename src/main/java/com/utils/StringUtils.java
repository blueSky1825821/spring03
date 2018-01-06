package com.utils;

import java.util.Objects;

public class StringUtils {

	/**
	 * 字符串是否为空
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isAllEmpty(Object... params) {

		for (Object param : params) {
			if (param != null && param.toString().length() > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串是否为空
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isEmpty(Object... params) {

		for (Object param : params) {
			if (param == null || "".equals(param)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 字符串是否不为空
	 * 
	 * @param params
	 * @return
	 */
	public static boolean isNotEmpty(Object... params) {

		for (Object param : params) {
			if (param == null || "".equals(param)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串左侧补零
	 * 
	 * @param obj
	 * @param strLength
	 * @return
	 */
	public static String addZeroLeft(Object obj, int strLength) {
		String str = obj == null ? "" : obj.toString();
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				// sb.append(str).append("0");//右补0
				str = sb.toString();
				strLen = str.length();
			}
		}

		return str;
	}

	/**
	 * 首字母转大写
	 * @param str
	 * @return
	 */
	public static String upperFirst(String str){
		if(str == null || str.isEmpty()){
			return null;
		}
		char[] cs = str.toCharArray();
		if(cs[0] >='a' && cs[0] <= 'z'){
			cs[0] = (char) (cs[0]+('A'-'a'));
		}
		return String.valueOf(cs);
	}

	/**
	 * 驼峰命名转化成_ 默认下划线为字段名
	 *
	 * @param s
	 * @return
	 */
	public static String camelToUnderLineName(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i >= 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					if (i > 0)
						sb.append("_");
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}


	/**
	 * 是否全不为空
	 *
	 * @param params
	 * @return
	 */
	public static boolean isNotBlank(String... params) {

		for (String param : params) {
			if (org.apache.commons.lang.StringUtils.isBlank(param)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNullOrEmpty(String param) {
		return Objects.equals("null", param) || param == null || param.length() == 0;
	}

	public static boolean isNotNullOrEmpty(String param) {
		return !isNullOrEmpty(param);
	}
}
