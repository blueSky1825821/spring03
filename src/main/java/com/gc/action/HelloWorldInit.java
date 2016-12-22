package com.gc.action;

import java.util.Date;

/**
 * @ClassName: HelloWorld
 * @Description: TODO(这里用一句话描述这个类的作用)
 *               <li>@author rocky</li>
 * @date 2016年6月27日 下午8:10:58
 */
public class HelloWorldInit {
	// 该变量用来存储字符串
	public String msg;

	// 该变量用来存储日期
	public Date date;

	// 初始化
	public void init() {
		this.msg = "HelloWorldInit";
		this.date = new Date();
	}

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

}
