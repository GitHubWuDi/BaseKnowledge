package com.wd.baseKnowledage.design.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *    抽象模板类
 * @author Administrator
 *
 */
public abstract class AbstractTemplateClass {

	private Logger logger = LoggerFactory.getLogger(AbstractTemplateClass.class);
	
	public abstract String primitiveOperation1();
	public abstract String primitiveOperation2();
	
	
	public void templateMethod() {
		String primitiveOperation1 = primitiveOperation1();
		String primitiveOperation2 = primitiveOperation2();
		logger.info("模板最后执行方法：{}", primitiveOperation1+primitiveOperation2);
	}
	
}
