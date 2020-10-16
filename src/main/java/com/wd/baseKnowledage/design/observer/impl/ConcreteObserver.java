package com.wd.baseKnowledage.design.observer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.baseKnowledage.design.observer.Observer;
import com.wd.baseKnowledage.design.observer.Subject;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月16日 上午8:59:14
* 类说明
*/
public class ConcreteObserver extends Observer {

	private Logger logger = LoggerFactory.getLogger(ConcreteObserver.class);
	private String name;
	private String observerState;
	private ConcreteSubject concreteSubject;
	
	public ConcreteObserver(ConcreteSubject concreteSubject,String name) {
		this.concreteSubject = concreteSubject;
		this.name = name;
	}
	
	
	@Override
	public void update() {
		observerState = concreteSubject.getState();
		logger.info("观察者{}新的状态是{}", name,observerState);
	}


	
	public ConcreteSubject getConcreteSubject() {
		return concreteSubject;
	}


	public void setConcreteSubject(ConcreteSubject concreteSubject) {
		this.concreteSubject = concreteSubject;
	}
	
	
	

}
