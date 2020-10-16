package com.wd.baseKnowledage.design.observer;

import com.wd.baseKnowledage.design.observer.impl.ConcreteObserver;
import com.wd.baseKnowledage.design.observer.impl.ConcreteSubject;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月16日 上午9:15:26
* 类说明
*/
public class Client {

	public static void main(String[] args) {
		ConcreteSubject s = new ConcreteSubject();
		s.attach(new ConcreteObserver(s, "A"));
		s.attach(new ConcreteObserver(s, "B"));
		s.attach(new ConcreteObserver(s, "C"));
		
		s.setState("ABC");
		s.notifyObserver();
	}
}
