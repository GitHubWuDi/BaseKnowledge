package com.wd.baseKnowledage.design.factory.create.impl;

import com.wd.baseKnowledage.design.factory.create.OperatorFactory;
import com.wd.baseKnowledage.design.factory.product.Operator;
import com.wd.baseKnowledage.design.factory.product.impl.DevisionOperator;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月23日 上午8:48:37
* 类说明
*/
public class DevisionOperatorFactory implements OperatorFactory {

	private double s1;
	private double s2;
	
	public DevisionOperatorFactory(double s1,double s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public Operator createOperatorFactory(){
		Operator devisionOperator = new DevisionOperator(s1, s2);
		return devisionOperator;
	}

}
