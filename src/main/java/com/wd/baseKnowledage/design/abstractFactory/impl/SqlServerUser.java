package com.wd.baseKnowledage.design.abstractFactory.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.baseKnowledage.design.abstractFactory.IUser;
import com.wd.baseKnowledage.design.abstractFactory.model.User;

public class SqlServerUser implements IUser {

	private static Logger logger = LoggerFactory.getLogger(AccessUser.class);
	
	@Override
	public void insert(User user) {
		logger.info("accsess用户姓名：{}，access用户ID：{}", user.getUserName(),user.getId());
		
	}

	@Override
	public String getUser(String id) {
		User user = new User();
		user.setId(id);
		user.setUserName("wudi");
		return id;
	}

}
