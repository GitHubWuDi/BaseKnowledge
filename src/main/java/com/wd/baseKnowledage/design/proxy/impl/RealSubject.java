package com.wd.baseKnowledage.design.proxy.impl;

import com.wd.baseKnowledage.design.proxy.Subject;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月21日 上午9:10:54
* 类说明
*/
public class RealSubject implements Subject {

	public SchoolGril schooGril;
	
	public  RealSubject(SchoolGril schooGril) {
		this.schooGril = schooGril;
	}
	
	@Override
	public void giveDolls() {
		String name = schooGril.getName();
		System.out.println(name+"送你娃娃！");
	
	}

	@Override
	public void giveFlower() {
		String name = schooGril.getName();
		System.out.println(name+"送你花！");
	}

	@Override
	public void giveCholocate() {
		String name = schooGril.getName();
		System.out.println(name+"送你巧克力！");
	}

}
