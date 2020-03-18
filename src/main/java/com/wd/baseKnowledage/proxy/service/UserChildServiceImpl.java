package com.wd.baseKnowledage.proxy.service;

import com.wd.baseKnowledage.proxy.model.User;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2019年10月9日 下午3:52:11
* 类说明
*/
public class UserChildServiceImpl extends UserServiceImpl {
     
	private String proxy = "abcddd";
	
	
	private String  getProxy() {
		return proxy;
	}
	
	
	@Override
	public User getUser(String id) {
		User user = new User();
		user.setGuid("123");
		user.setName("wudi");
		user.setSex("male");
		System.out.println("getUser from database.");
		String proxy2 = getProxy();
		System.out.println(proxy2);
		return user;
	}
}
