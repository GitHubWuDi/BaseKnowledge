package com.wd.baseKnowledage.design.builder;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月15日 上午8:54:18
* 类说明
*/
public class Director {

	public void construct(Builder builder) {
		builder.buidPartA();
		builder.buidPartB();
	}
	
}
