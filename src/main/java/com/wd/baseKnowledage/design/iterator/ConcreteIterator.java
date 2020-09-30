package com.wd.baseKnowledage.design.iterator;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午11:53:28
* 类说明    迭代具体实现类
*/
public class ConcreteIterator implements Iterator {

	
	private ConcreteAggregate concreteAggregate;
	private int current=0;
	
	public ConcreteIterator(ConcreteAggregate concreteAggregate) {
		this.concreteAggregate = concreteAggregate;
	}
	
	@Override
	public Integer first() {
		Integer location = concreteAggregate.getList().get(0);
		return location;
	}

	@Override
	public Integer next() {
		Integer ret = null;
		if(current<concreteAggregate.count()) {
			ret = concreteAggregate.getList().get(current);
		}
		current++;
		return ret;
	}

	@Override
	public boolean isdone() {
		return current<concreteAggregate.count()?true:false;
	}

	@Override
	public Integer currentItem() {
		return concreteAggregate.getList().get(current);
	}

}
