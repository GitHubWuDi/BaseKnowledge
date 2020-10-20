package com.wd.baseKnowledage.design.mediator.impl;

import com.wd.baseKnowledage.design.mediator.Country;
import com.wd.baseKnowledage.design.mediator.UnitedNations;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月20日 下午6:43:36
* 类说明
*/
public class CHINA extends Country {

	public CHINA(UnitedNations mediator) {
		super(mediator);
	}
	public void declare(String message) {
		mediator.declare(message, this);
	}
	public void getMessage(String message) {
		logger.info("中国获得对方信息：{}", message);
	} 
	
	

}
