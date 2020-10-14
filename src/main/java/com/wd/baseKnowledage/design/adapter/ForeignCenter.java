package com.wd.baseKnowledage.design.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月14日 上午8:38:29
* 类说明 外籍中锋（需要适配的对象）
*/
public class ForeignCenter {

	private static Logger logger = LoggerFactory.getLogger(ForeignCenter.class);
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void jinggong() {
		logger.info("外籍中锋{}进攻", name);
	} 
	
	
	public void fangshou() {
		logger.info("外籍中锋{}防守", name);
	} 
	
}
