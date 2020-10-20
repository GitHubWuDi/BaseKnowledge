package com.wd.baseKnowledage.design.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月20日 下午6:40:45
* 类说明
*/
public abstract class Country {

	protected static Logger logger  = LoggerFactory.getLogger(Country.class);
	
	protected UnitedNations mediator;
	
	public Country(UnitedNations mediator) {
		this.mediator = mediator;
	}
	
	
	
	
}
