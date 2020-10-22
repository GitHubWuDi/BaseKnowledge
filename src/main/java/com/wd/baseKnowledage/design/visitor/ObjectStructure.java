package com.wd.baseKnowledage.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月22日 上午8:59:17
* 类说明 对象结构
*/
public class ObjectStructure {

	private List<Person> list = new ArrayList<>();
	
	
	public void attach(Person person) {
		list.add(person);
	}
	
	public void detach(Person person) {
		list.remove(person);
	}
	
	public void display(Action visitor) {
		
		for (Person person : list) {
			person.accept(visitor);
		}
		
	}
}
