package com.wd.baseKnowledage.design.abstractFactory;

import com.wd.baseKnowledage.design.abstractFactory.model.User;

public interface IUser {

	public void insert(User user);
	
	public String getUser(String id);
}
