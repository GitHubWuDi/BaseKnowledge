package com.wd.baseKnowledage.design.abstractFactory;

import com.wd.baseKnowledage.design.abstractFactory.model.Department;

public class Client {
    
	public static void main(String[] args) {
		IDepartMent departMent = DataAccess.createDepartMent("sqlServer");
		Department department2 = new Department();
		
		departMent.insert(department2);
		departMent.getDeparntMent("1");
	}
	
	
}
