package com.wd.baseKnowledage.design.iterator;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午11:55:15
* 类说明
*/
public interface Aggregate {
    
	public Iterator createIterator(); //创建迭代器
	
}
