package com.wd.baseKnowledage.design.overtrue.multiStatus;

import com.wd.baseKnowledage.design.overtrue.Operator;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月15日 上午8:52:42
* 类说明  加法运算符
*/
public class AddOperator implements Operator {

	@Override
	public double getResult(double numberA, double numberB) {
		double result = numberA+numberB;
		return result;
	}

}
