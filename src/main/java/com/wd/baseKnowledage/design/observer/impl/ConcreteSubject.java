package com.wd.baseKnowledage.design.observer.impl;

import com.wd.baseKnowledage.design.observer.Subject;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月16日 上午9:00:37
* 类说明
*/
public class ConcreteSubject extends Subject {

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
