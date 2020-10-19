package com.wd.baseKnowledage.design.facade;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月19日 下午7:06:08
* 类说明
*/
public class Client {

	
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.method1();
		facade.method2();
	}
	
}
