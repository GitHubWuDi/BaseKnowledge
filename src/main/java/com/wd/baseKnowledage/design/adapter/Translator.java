package com.wd.baseKnowledage.design.adapter;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月14日 上午8:46:08
* 类说明
*/
public class Translator extends Player {

	private ForeignCenter ym = new ForeignCenter();
	
	public Translator(String name) {
		super(name);
	}

	@Override
	public void attack() {
		ym.setName(name);
		ym.jinggong();
	}

	@Override
	public void defense() {
		ym.setName(name);
		ym.fangshou();
	}

}
