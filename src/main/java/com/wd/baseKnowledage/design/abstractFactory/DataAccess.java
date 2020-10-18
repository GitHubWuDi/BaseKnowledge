package com.wd.baseKnowledage.design.abstractFactory;

import com.wd.baseKnowledage.design.abstractFactory.impl.AccessDepartMent;
import com.wd.baseKnowledage.design.abstractFactory.impl.AccessUser;
import com.wd.baseKnowledage.design.abstractFactory.impl.SqlServerUser;
import com.wd.baseKnowledage.design.abstractFactory.impl.SqlServiceDepartMent;

/**
 * 用简单工厂模式封装dataAccess
 * @author Administrator
 *
 */
public class DataAccess {

	public  static IUser createUser(String dbType) {
		IUser user = null;
		switch (dbType) {
		case "sqlServer":
			user = new SqlServerUser();
			break;
		case "access":
			user = new AccessUser();
			break;
		default:
			break;
		}
		return user;
	}
	
	
	public  static IDepartMent createDepartMent(String dbType) {
		IDepartMent departMent = null;
		switch (dbType) {
		case "sqlServer":
			departMent = new SqlServiceDepartMent();
			break;
		case "access":
			departMent = new AccessDepartMent();
			break;
		default:
			break;
		}
		return departMent;
	}
	
	
}
