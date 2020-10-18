package com.wd.baseKnowledage.design.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteTemplate extends AbstractTemplateClass {

	private Logger logger = LoggerFactory.getLogger(ConcreteTemplate.class);
	
	@Override
	public String primitiveOperation1() {
		return "操作1";
	}

	@Override
	public String primitiveOperation2() {
		return "操作2";
	}

}
