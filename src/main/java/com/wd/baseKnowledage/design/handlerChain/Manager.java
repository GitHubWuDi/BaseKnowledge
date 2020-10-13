package com.wd.baseKnowledage.design.handlerChain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月13日 上午8:14:14
* 类说明  管理者抽象类
*/
public abstract class Manager {
	
	protected static Logger logger = LoggerFactory.getLogger(Manager.class);
	
	protected String name;
	
	protected Manager mananger;
	
	
	public Manager(String name) {
		this.name = name;
	}

	public void setMananger(Manager mananger) {
		this.mananger = mananger;
	}
	
	
	public abstract void requestApplication(Request request);
	
	
	
	
	
}
