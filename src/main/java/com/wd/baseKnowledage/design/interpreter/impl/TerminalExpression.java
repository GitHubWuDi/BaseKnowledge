package com.wd.baseKnowledage.design.interpreter.impl;

import com.wd.baseKnowledage.design.interpreter.AbstractExpression;
import com.wd.baseKnowledage.design.interpreter.Context;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月21日 上午8:46:34
* 类说明
*/
public class TerminalExpression extends AbstractExpression {

	@Override
	public void interpret(Context context) {
		logger.info("终端解释器");		
	}

}
