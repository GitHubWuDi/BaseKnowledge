package com.wd.baseKnowledage.design.decorator;

import com.wd.baseKnowledage.design.decorator.dec.ConcreteDecorateA;
import com.wd.baseKnowledage.design.decorator.dec.ConcreteDecorateB;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月18日 上午8:57:13
* 类说明 装饰者模式客户端
*/
public class DecoratorClient {
     
	public static void main(String[] args) {
		ConcreteComponentA componentA = new ConcreteComponentA();
		ConcreteDecorateA concreteDecorateA = new ConcreteDecorateA(componentA);
		ConcreteDecorateB concreteDecorateb = new ConcreteDecorateB(concreteDecorateA);
		concreteDecorateb.operation();
	}
}
