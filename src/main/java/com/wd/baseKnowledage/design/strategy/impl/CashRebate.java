package com.wd.baseKnowledage.design.strategy.impl;

import com.wd.baseKnowledage.design.strategy.CashSuper;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月16日 上午9:22:01
* 类说明 打折
*/
public class CashRebate implements CashSuper {

	private double rebate;
	
	public CashRebate(double rebate) {
		this.rebate = rebate;
	}
	
	
	@Override
	public double acceptCash(double money) {
		if(rebate>1||rebate<0) {
			throw new RuntimeException("打折率为"+rebate+",不合符要求！");
		}else {
			money = money*rebate;
		}
		return money;
	}

}
