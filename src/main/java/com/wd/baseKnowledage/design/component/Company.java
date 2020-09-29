package com.wd.baseKnowledage.design.component;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午9:31:44
* 类说明
*/
public abstract class Company {

	protected String name;
	
	public Company(String name) {
		this.name = name;
	}
	
	
	public abstract void add(Company c);
	public abstract void remove(Company c);
	public abstract void disPlay(int depth);
	public abstract void lineOfDuty(); //履行职责
	
	
}
