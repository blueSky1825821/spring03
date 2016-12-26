/**    
* @Title: HelloWorld.java  
* @Package myApp  
* @Description: TODO(用一句话描述该文件做什么)  
* @author rocky   
* @date 2016年6月27日 下午8:10:58   
*/
package com.gc.action;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: HelloWorld
 * @Description: TODO(这里用一句话描述这个类的作用)
 *               <li>@author rocky</li>
 * @date 2016年6月27日 下午8:10:58
 */
public class HelloWorldList {
	// 定义一个List变量msg
	private List msg = null;

	// 该变量用来存储日期
	public Date date;

	public List getMsg() {
		return msg;
	}

	public void setMsg(List msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// 构造器注入需要添加构造方法
	public HelloWorldList() {
		super();
	}

}
