package com.wd.baseKnowledage.proxy.jdkproxy;

import java.util.UUID;

import com.wd.baseKnowledage.proxy.model.User;
import com.wd.baseKnowledage.proxy.service.UserService;

public class UserProxyMain {

	public static void main(String[] args) {
		UserProxy userProxy = new UserProxy();
		UserService userService = userProxy.getProxy();
		User user = new User();
		user.setGuid(UUID.randomUUID().toString());
		user.setName("wudi");
		user.setSex("male");
		userService.addUser(user);
	}
	
	
	
}
