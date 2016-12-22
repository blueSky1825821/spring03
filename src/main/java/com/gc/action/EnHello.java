/**    
* @Title: EnHello.java  
* @Package com.gc.action  
* @Description: TODO(用一句话描述该文件做什么)  
* @author rocky   
* @date 2016年6月27日 下午11:52:17   
*/
package com.gc.action;

import com.gc.impl.Hello;

/**
 * @ClassName: EnHello
 * @Description: TODO(作用:)
 * @author rocky
 * @date 2016年6月27日 下午11:52:17
 */
public class EnHello implements Hello {

	private String msg = null;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/*
	 * 用来输出英文问候语
	 * 
	 * @see com.gc.Hello#doSalutation()
	 */
	public String doSalutation() {
		// TODO Auto-generated method stub
		return "Hello" + msg;
	}

}
