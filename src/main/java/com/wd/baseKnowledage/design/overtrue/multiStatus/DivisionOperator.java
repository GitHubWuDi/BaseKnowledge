package com.wd.baseKnowledage.design.overtrue.multiStatus;

import com.wd.baseKnowledage.design.overtrue.Operator;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月15日 上午8:58:00
* 类说明 除法运算符
*/
public class DivisionOperator implements Operator{

	@Override
	public double getResult(double numberA, double numberB) {
		if(numberB<0) {
			throw new RuntimeException(numberB+"<0,分母小于0，请检查！");
		}
		double result = numberA/numberB;
		return result;
	}

}
