package com.wd.baseKnowledage.design.overtrue;

import com.wd.baseKnowledage.design.overtrue.multiStatus.AddOperator;
import com.wd.baseKnowledage.design.overtrue.multiStatus.DivisionOperator;
import com.wd.baseKnowledage.design.overtrue.multiStatus.MultiOperator;
import com.wd.baseKnowledage.design.overtrue.multiStatus.SubOperator;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月15日 上午9:01:55
* 类说明    运算符工厂
*/
public class OperatorFactory {

	
	private Operator operator;
	
	public double exexOperator(double numberA,double numberB,String operatorValue) {
		double result =0.0;
		switch (operatorValue) {
		case "+":
			operator = new AddOperator();
			break;
		case "-":
			operator = new SubOperator();
			break;
		case "*":
			operator = new MultiOperator();
			break;
		case "/":
			operator = new DivisionOperator();
			break;
		default:
			throw new RuntimeException(operatorValue+"暂时不支持，仅支持加减乘除，请检查！");
		}
		result = operator.getResult(numberA, numberB);
		return result;
		
	}
	
	
	
}
