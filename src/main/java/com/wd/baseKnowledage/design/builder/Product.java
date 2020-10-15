package com.wd.baseKnowledage.design.builder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月15日 上午8:43:40
* 类说明 产品类，由多个部件组成
*/
public class Product {

	private List<String> parts = new ArrayList<>();
	private static Logger logger = LoggerFactory.getLogger(Product.class);
	
	public void add(String part) {
		parts.add(part);
	}
	
	public void show() {
		for (String part : parts) {
			logger.info("产品部件包括：{}", part);
		}
	} 
	
}
