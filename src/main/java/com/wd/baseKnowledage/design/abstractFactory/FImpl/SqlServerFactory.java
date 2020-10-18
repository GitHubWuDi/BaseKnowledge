package com.wd.baseKnowledage.design.abstractFactory.FImpl;

import com.wd.baseKnowledage.design.abstractFactory.IDepartMent;
import com.wd.baseKnowledage.design.abstractFactory.IFactory;
import com.wd.baseKnowledage.design.abstractFactory.IUser;
import com.wd.baseKnowledage.design.abstractFactory.impl.SqlServerUser;
import com.wd.baseKnowledage.design.abstractFactory.impl.SqlServiceDepartMent;

public class SqlServerFactory implements IFactory {

	@Override
	public IUser createUser() {
		return new SqlServerUser();
	}

	@Override
	public IDepartMent createDepartMent() {
		return new SqlServiceDepartMent();
	}

}
