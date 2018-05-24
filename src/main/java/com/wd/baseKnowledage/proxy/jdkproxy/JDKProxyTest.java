package com.wd.baseKnowledage.proxy.jdkproxy;

import java.lang.reflect.Proxy;

import com.wd.baseKnowledage.proxy.model.User;
import com.wd.baseKnowledage.proxy.service.UserService;
import com.wd.baseKnowledage.proxy.service.UserServiceImpl;

/**
* @author wudi
* @version 创建时间：2018年5月24日 下午11:13:53
* @ClassName JDKProxyTest
* @Description 类描述
*/
public class JDKProxyTest {
       
	public static void main(String[] args) {
		Object obj = new UserServiceImpl();
		JDKProxyUtil jdkProxyUtil = new JDKProxyUtil(obj);
		UserService  userService = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), UserServiceImpl.class.getInterfaces(), jdkProxyUtil);
		userService.getUser("123");
		userService.addUser(new User());
	}
}
