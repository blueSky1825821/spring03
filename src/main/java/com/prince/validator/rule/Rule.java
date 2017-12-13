package com.prince.validator.rule;

/**
 * 校验规则，用于扩展校验规则
 * @author cdwangzijian
 *
 */
public interface Rule {
	public String getMessage();
	public boolean isValid();
}
