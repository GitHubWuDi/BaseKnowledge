package com.wd.baseKnowledage.design.strategy.impl;

import com.wd.baseKnowledage.design.strategy.CashSuper;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月16日 上午9:06:29
* 类说明   正常付费
*/
public class NormalCash implements CashSuper {

	@Override
	public double acceptCash(double money) {
		return money;
	}

	
}
