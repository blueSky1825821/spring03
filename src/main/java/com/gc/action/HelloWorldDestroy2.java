package com.gc.action;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName: HelloWorld
 * @Description: TODO(销毁没有实现)
 *               <li>@author rocky</li>
 * @date 2016年6月27日 下午8:10:58
 */
public class HelloWorldDestroy2 implements InitializingBean, DisposableBean {
	// 该变量用来存储字符串
	public String msg;

	// 该变量用来存储日期
	public Date date;

	public void init() {
		this.msg = "HelloWorldDestroy";
		this.date = new Date();
	}

	public HelloWorldDestroy2() {
		super();
	}

	// 销毁方法
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

	/*
	 * (销毁方法)
	 * 
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	public void destroy() throws Exception {

		this.msg = "";
		this.date = null;
		System.out.println("你销毁了 msg " + msg + "和date " + date);

	}

	/*
	 * (初始化)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		this.msg = "HelloWorldDestroy";
		this.date = new Date();

	}

}
