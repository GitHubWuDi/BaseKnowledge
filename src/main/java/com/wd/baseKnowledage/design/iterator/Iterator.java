package com.wd.baseKnowledage.design.iterator;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午11:46:07
* 类说明
*/
public interface Iterator {
    
	public Integer first(); //第一个
    public Integer next(); //下一个
    public boolean isdone(); //判断是否到结尾
    public Integer currentItem(); //当前节点
    
}
