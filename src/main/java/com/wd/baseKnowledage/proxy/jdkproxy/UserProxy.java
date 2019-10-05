package com.wd.baseKnowledage.proxy.jdkproxy;

import java.lang.reflect.Proxy;

import com.wd.baseKnowledage.proxy.service.UserService;
import com.wd.baseKnowledage.proxy.service.UserServiceImpl;

public class UserProxy {

	private UserService userService = new UserServiceImpl();
	
	/**
	 * 获得代理类的方法
	 * @return
	 */
	public UserService getProxy(){
		return (UserService)Proxy.newProxyInstance(UserProxy.class.getClassLoader(), userService.getClass().getInterfaces(), new UserProxyHandler());
	}
	
	
	
}
