package com.wd.baseKnowledage.design.factory.product.impl;

import com.wd.baseKnowledage.design.factory.product.Operator;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月23日 上午8:40:03
* 类说明
*/
public class SubOperator implements Operator {

	private double s1;
	private double s2; 
	
	public SubOperator(double s1,double s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	
	
	@Override
	public double getResult() {
		double result = s1 - s2;
		return result;
	}

}
