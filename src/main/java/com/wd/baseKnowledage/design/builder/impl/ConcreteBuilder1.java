package com.wd.baseKnowledage.design.builder.impl;

import com.wd.baseKnowledage.design.builder.Builder;
import com.wd.baseKnowledage.design.builder.Product;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月15日 上午8:50:03
* 类说明
*/
public class ConcreteBuilder1 extends Builder {

	private Product product = new Product();
	
	@Override
	public void buidPartA() {
		product.add("部件A");
	}

	@Override
	public void buidPartB() {
		product.add("部件B");		
	}

	@Override
	public Product getResult() {
		return product;
	}

}
