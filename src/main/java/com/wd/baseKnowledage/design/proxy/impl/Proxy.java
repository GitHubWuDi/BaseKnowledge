package com.wd.baseKnowledage.design.proxy.impl;

import com.wd.baseKnowledage.design.proxy.Subject;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月21日 上午9:17:54
* 类说明
*/
public class Proxy implements Subject {

	private RealSubject realSubject;
	public Proxy (SchoolGril schoolGril) {
		realSubject = new RealSubject(schoolGril);
	}
	
	@Override
	public void giveDolls() {
		realSubject.giveDolls();
	}

	@Override
	public void giveFlower() {
		realSubject.giveFlower();		
	}

	@Override
	public void giveCholocate() {
		realSubject.giveCholocate();		
	}

}
