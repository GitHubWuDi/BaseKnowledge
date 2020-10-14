package com.wd.baseKnowledage.design.adapter;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月14日 上午8:43:36
* 类说明   适配器的目标进行抽象
*/
public abstract class Player {
  
	protected String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public abstract void attack(); //进攻
	
	public abstract void defense(); //防守
	
	
	
}
