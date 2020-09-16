package com.wd.baseKnowledage.design.strategy.impl;

import com.wd.baseKnowledage.design.strategy.CashSuper;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月16日 上午9:11:29
* 类说明    满减操作
*/
public class CashReturn implements CashSuper {

	private double denominatorPrice;   //分母价
	private double molecularPrice; //分子价
	
	public CashReturn(double denominatorPrice,double molecularPrice) {
		this.denominatorPrice = denominatorPrice;
		this.molecularPrice = molecularPrice;
	}
	
	
	@Override
	public double acceptCash(double money) {
		double count = money/denominatorPrice;
		if(count<1) {
			return money;
		}else {
			double subPrice = count*molecularPrice;
			money = money-subPrice;
			if(money<0) {
				throw new RuntimeException("付款值小0,请检查！");
			}
			return money;
		}
	}

}
