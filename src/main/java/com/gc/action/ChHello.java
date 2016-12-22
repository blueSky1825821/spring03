/**    
* @Title: ChHello.java  
* @Package com.gc.action  
* @Description: TODO(用一句话描述该文件做什么)  
* @author rocky   
* @date 2016年6月27日 下午11:49:20   
*/
package com.gc.action;

import com.gc.impl.Hello;

/**  
* @ClassName: ChHello  
* @Description: TODO(作用:)  
* @author rocky  
* @date 2016年6月27日 下午11:49:20    
*/
public class ChHello implements Hello{

	private String msg = null;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/* (non-Javadoc)
	 * @see com.gc.Hello#doSalutation()
	 */
	public String doSalutation() {
		// TODO Auto-generated method stub
		return "你好" + msg;
	}
	
}
