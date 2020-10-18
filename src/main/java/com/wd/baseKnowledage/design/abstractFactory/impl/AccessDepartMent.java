package com.wd.baseKnowledage.design.abstractFactory.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.baseKnowledage.design.abstractFactory.IDepartMent;
import com.wd.baseKnowledage.design.abstractFactory.model.Department;
import com.wd.baseKnowledage.design.abstractFactory.model.User;

public class AccessDepartMent implements IDepartMent {

	private static Logger logger = LoggerFactory.getLogger(AccessDepartMent.class);
	@Override
	public void insert(Department department) {
		logger.info("accsess用户姓名：{}，access用户ID：{}", department.getDepartName(),department.getId());	
	
	}
	@Override
	public String getDeparntMent(String id) {
		Department departMent = new Department();
		departMent.setId(id);
		departMent.setDepartName("a部门");
		return id;
	}

}
