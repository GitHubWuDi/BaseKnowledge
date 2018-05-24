package com.wd.baseKnowledage.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.Data;

/**
* @author wudi
* @version 创建时间：2018年5月24日 下午11:10:54
* @ClassName 类名称
* @Description jdk Proxy 该方式有一个要求， 被代理的对象必须实现接口，而且只有接口中的方法才能被代理 。
*/
@Data
public class JDKProxyUtil implements InvocationHandler {
     private Object target; //aop目标

     public JDKProxyUtil(Object target){
    	 this.target = target;
     }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("do sth before....");
		Object result =  method.invoke(target, args);
		System.out.println("do sth after....");
		return result;
	}
     
}
