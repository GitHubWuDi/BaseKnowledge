package com.wd.baseKnowledage.design.overtrue.multiStatus;

import com.wd.baseKnowledage.design.overtrue.Operator;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月15日 上午8:54:10
* 类说明  减法操作运算
*/
public class SubOperator implements Operator {

	@Override
	public double getResult(double numberA, double numberB) {
		double result = numberA-numberB; 
		return result;
	}

}
