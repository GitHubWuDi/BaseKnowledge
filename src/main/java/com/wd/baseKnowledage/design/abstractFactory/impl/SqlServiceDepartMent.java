package com.wd.baseKnowledage.design.abstractFactory.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.baseKnowledage.design.abstractFactory.IDepartMent;
import com.wd.baseKnowledage.design.abstractFactory.model.Department;
import com.wd.baseKnowledage.design.abstractFactory.model.User;

public class SqlServiceDepartMent implements IDepartMent {

	private static Logger logger = LoggerFactory.getLogger(SqlServiceDepartMent.class);
	@Override
	public void insert(Department department) {
		logger.info("sqlService部门姓名：{}，sqlService部门ID：{}", department.getDepartName(),department.getId());	
	
	}
	@Override
	public String getDeparntMent(String id) {
		Department departMent = new Department();
		departMent.setId(id);
		departMent.setDepartName("b部门");
		return id;
	}

}
