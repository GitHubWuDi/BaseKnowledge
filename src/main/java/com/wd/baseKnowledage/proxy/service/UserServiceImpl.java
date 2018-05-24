package com.wd.baseKnowledage.proxy.service;

import com.wd.baseKnowledage.proxy.model.User;

/**
* @author wudi
* @version 创建时间：2018年5月24日 下午11:07:26
* @ClassName 类名称
* @Description 类描述
*/
public class UserServiceImpl implements UserService {

	@Override
	public void addUser(User user) {
		System.out.println("add user into database.");
	}

	@Override
	public User getUser(String id) {
		User user = new User();
		user.setGuid("123");
		user.setName("wudi");
		user.setSex("male");
		System.out.println("getUser from database.");
		return user;
	}

}
