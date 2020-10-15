package com.wd.baseKnowledage.design.builder;

import com.wd.baseKnowledage.design.builder.impl.ConcreteBuilder1;
import com.wd.baseKnowledage.design.builder.impl.ConcreteBuilder2;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月15日 上午8:56:35
* 类说明
*/
public class Client {

	public static void main(String[] args) {
		Director director = new Director();
		Builder b1 = new ConcreteBuilder1();
		Builder b2 = new ConcreteBuilder2();
		director.construct(b1);
		Product result1 = b1.getResult();
		result1.show();
		
		director.construct(b2);
		Product result2 = b1.getResult();
		result2.show();
	}
	
}
