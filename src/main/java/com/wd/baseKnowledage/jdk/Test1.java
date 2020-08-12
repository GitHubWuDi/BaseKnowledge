package com.wd.baseKnowledage.jdk;

import java.lang.reflect.Method;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年2月9日 下午2:55:58
* 类说明
*/
public class Test1 {

	
	static String str = new String("hello");
	static char[] ch = {'a','b','c'};
	
	public  void fun(String str,char ch[]) {
		str = "world";
		ch[0] = 'd';
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader classLoader = Test1.class.getClassLoader();
		Class<?> loadClass = classLoader.loadClass("com.wd.baseKnowledage.jdk.Test3");
		Method[] declaredMethods = loadClass.getDeclaredMethods();
		System.out.println(declaredMethods);
	}
}
