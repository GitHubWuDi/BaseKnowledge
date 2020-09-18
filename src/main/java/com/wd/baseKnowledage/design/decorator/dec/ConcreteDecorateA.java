package com.wd.baseKnowledage.design.decorator.dec;

import com.wd.baseKnowledage.design.decorator.Component;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月18日 上午8:51:11
* 类说明
*/
public class ConcreteDecorateA extends Decorate {

	public ConcreteDecorateA(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		component.operation();
		System.out.println("ConcreteDecorateA");
		
	}

}
