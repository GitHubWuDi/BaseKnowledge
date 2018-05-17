package com.wd.baseKnowledage.lambda;
/**
* @author wudi
* @version 创建时间：2018年5月17日 下午11:01:07
* @ClassName 类名称
* @Description 类描述
* (params) -> expression
*(params) -> statement
*(params) -> { statements }
*/
public class ThreadLambdaTest {

	public static void main(String[] args) {
		new Thread(()->System.out.println("thread lambda expression")).start(); 
	}
	
	
}
