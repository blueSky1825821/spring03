package com.common;


import java.io.Serializable;

public class CodeWithDesc implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1295633495239647523L;

	/**
	 * 默认error code
	 */
	public static final CodeWithDesc NIL_CODE = new CodeWithDesc(
			Long.MIN_VALUE, "");

	private final long code;

	private final String desc;

	CodeWithDesc(long code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public long getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return ToStringHelper.create(this).add("code", this.code)
				.add("desc", this.desc).toString();
	}

}