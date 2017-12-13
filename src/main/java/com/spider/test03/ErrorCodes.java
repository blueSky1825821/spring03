package com.spider.test03;

import com.common.ToStringHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorCodes implements Iterable<CodeWithDesc>, Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6882004375409212817L;

	private final List<CodeWithDesc> errors = new ArrayList<CodeWithDesc>(1);

	ErrorCodes add(long code, String desc) {
		errors.add(new CodeWithDesc(code, desc));
		return this;
	}

	/**
	 * 取得第一个出错信息.<br />
	 * 一般情况都是取头一个.
	 * @return
	 */
	public CodeWithDesc one() {
		CodeWithDesc code = CodeWithDesc.NIL_CODE;
		if (errors.size() > 0) {
			code = errors.get(0);
		}
		return code;
	}

	/**
	 * ErrorCodes 可以直接for()迭代 <br />
	 * 一般用于 > 1 出错信息的情况下.
	 *
	 * @see Iterable#iterator()
	 */
	public Iterator<CodeWithDesc> iterator() {
		return this.errors.iterator();
	}

	/**
	 * 不建议使用.除非上面两种方式实在满足不了需求.
	 *
	 * @deprecated
	 * @return
	 */
	public List<CodeWithDesc> errors() {
		return this.errors;
	}

	@Override
	public String toString() {
		return ToStringHelper.create(this).add("errorCodes", this.errors)
				.toString();
	}
}
