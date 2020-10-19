package com.wd.baseKnowledage.design.facade.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月19日 下午6:58:50
* 类说明
*/
public class SubSystemTwo {
     
	private static Logger logger  = LoggerFactory.getLogger(SubSystemTwo.class);
	
	public void methodB() {
		logger.info("执行方B:{}", "B");
	}
}
