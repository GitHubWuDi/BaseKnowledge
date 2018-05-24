package com.wd.baseKnowledage.proxy.cglibProxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
* @author wudi
* @version 创建时间：2018年5月24日 下午11:19:40
* @ClassName 类名称
* @Description 类描述
*/
public class CGProxy implements MethodInterceptor {

	private Object target;	// 被代理对象
	public CGProxy(Object target){
		this.target = target;
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		System.out.println("do sth before....");
		Object result = proxy.invokeSuper(arg0, arg2);
		System.out.println("do sth after....");
		return result;
	}
	
	public Object getProxyObject() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());	// 设置父类
		// 设置回调
		enhancer.setCallback(this);	// 在调用父类方法时，回调 this.intercept()
		// 创建代理对象
		return enhancer.create();
	}

}
