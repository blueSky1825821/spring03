package com.gc.action;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName: HelloWorld
 * @Description: TODO(不需要添加构造器)
 *               <li>@author rocky</li>
 * @date 2016年6月27日 下午8:10:58
 */
public class HelloWorldInit2 implements InitializingBean {
	// 该变量用来存储字符串
	public String msg;

	// 该变量用来存储日期
	public Date date;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * 初始化
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.msg = "HelloWorldInit";
		this.date = new Date();
	}

}
