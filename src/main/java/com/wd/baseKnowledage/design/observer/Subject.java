package com.wd.baseKnowledage.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月16日 上午8:52:25
* 类说明
*/
public abstract class Subject {

	private List<Observer> list = new ArrayList<>();
	
	
	/**
	 * 添加观察者
	 * @param observer
	 */
	public void attach(Observer observer) {
		list.add(observer);
	}
	
	public void detach(Observer observer) {
		list.remove(observer);
	}
	
	
	public void notifyObserver() {
		for (Observer observer : list) {
			observer.update();
		}
	}
	
	
	
}
