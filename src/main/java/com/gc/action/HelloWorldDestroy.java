package com.gc.action;

import java.util.Date;

/**
 * @ClassName: HelloWorld
 * @Description: TODO(销毁没有实现)
 *               <li>@author rocky</li>
 * @date 2016年6月27日 下午8:10:58
 */
public class HelloWorldDestroy {
	// 该变量用来存储字符串
	public String msg;

	// 该变量用来存储日期
	public Date date;

	// 初始化
	public void init() {
		this.msg = "HelloWorldDestroy";
		this.date = new Date();
	}
	
	
	
	public HelloWorldDestroy() {
		super();
	}



	//销毁方法
	public void cleanup() {
		this.msg = "";
		this.date = null;
		System.out.println("你销毁了 msg " + msg + "和date " + date);
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
