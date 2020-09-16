package com.wd.baseKnowledage.design.strategy;

import com.wd.baseKnowledage.design.strategy.impl.CashRebate;
import com.wd.baseKnowledage.design.strategy.impl.CashReturn;
import com.wd.baseKnowledage.design.strategy.impl.NormalCash;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月16日 上午9:29:07
* 类说明
*/
public class CashContext {

	private CashSuper casheSuper;
	
	public  CashContext(String type) {
		switch (type) {
		case "normal":
			casheSuper = new NormalCash();
			break;
       case "rebate":
    	   casheSuper = new CashRebate(0.8); //八折优惠
			break;
       case "return":
    	   casheSuper = new CashReturn(300, 100);
			break;
		default:
			break;
		}
	}
	
	public double getResult(double money) {
		double acceptCash = casheSuper.acceptCash(money);
		return acceptCash;
	}
	
	
}
