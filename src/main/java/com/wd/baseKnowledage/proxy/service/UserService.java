package com.wd.baseKnowledage.proxy.service;

import com.wd.baseKnowledage.proxy.model.User;

/**
* @author wudi
* @version 创建时间：2018年5月24日 下午11:03:24
* @ClassName 类名称
* @Description 类描述
*/
public interface UserService {
     
	 public void addUser(User user);
	 
	 public User getUser(String id);
}
