package com.wd.baseKnowledage.design.iterator;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 下午7:14:38
* 类说明
*/
public class Client {

	
	public static void main(String[] args) {
		ConcreteAggregate concreteAggregate  = new ConcreteAggregate();
		concreteAggregate.getList().add(1);
		concreteAggregate.getList().add(2);
		concreteAggregate.getList().add(3);
		concreteAggregate.getList().add(4);
		concreteAggregate.getList().add(5);
		concreteAggregate.getList().add(6);
		concreteAggregate.getList().add(7);
		concreteAggregate.getList().add(8);
		Iterator iterator = new ConcreteIterator(concreteAggregate);
		while(iterator.isdone()) {
			System.out.println(iterator.currentItem());
			iterator.next();
		}
	}
	
}
