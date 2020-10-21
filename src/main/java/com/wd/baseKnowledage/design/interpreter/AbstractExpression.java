package com.wd.baseKnowledage.design.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月21日 上午8:43:55
* 类说明
*/
public abstract class AbstractExpression {

	protected static Logger logger = LoggerFactory.getLogger(AbstractExpression.class);
	
	
	public abstract void interpret(Context context);
	
	
}
