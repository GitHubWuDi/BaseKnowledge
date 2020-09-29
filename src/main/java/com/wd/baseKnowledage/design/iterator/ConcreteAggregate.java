package com.wd.baseKnowledage.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午11:57:14
* 类说明
*/
public class ConcreteAggregate implements Aggregate {

	private List<Integer> list = new ArrayList<>();
	
	@Override
	public Iterator createIterator() {
		
		return new ConcreteIterator(this);
	}

	public int count() {
		int size = getList().size();
		return size;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	
	
	
	
}
