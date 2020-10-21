package com.wd.baseKnowledage.design.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.wd.baseKnowledage.design.interpreter.impl.NonterminallExpression;
import com.wd.baseKnowledage.design.interpreter.impl.TerminalExpression;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月21日 上午8:49:53
* 类说明  解释器模式调用方式
*/
public class Client {

	public static void main(String[] args) {
		Context context = new Context();
		List<AbstractExpression> list = new ArrayList<>();
		list.add(new TerminalExpression());
		list.add(new NonterminallExpression());
		for (AbstractExpression abstractExpression : list) {
			abstractExpression.interpret(context);
		}
	}
}
