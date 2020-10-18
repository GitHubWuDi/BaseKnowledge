package com.wd.baseKnowledage.design.abstractFactory.FImpl;

import com.wd.baseKnowledage.design.abstractFactory.IDepartMent;
import com.wd.baseKnowledage.design.abstractFactory.IFactory;
import com.wd.baseKnowledage.design.abstractFactory.IUser;
import com.wd.baseKnowledage.design.abstractFactory.impl.AccessDepartMent;
import com.wd.baseKnowledage.design.abstractFactory.impl.AccessUser;

public class AccessFactory implements IFactory {

	@Override
	public IUser createUser() {
		return new AccessUser();
	}

	@Override
	public IDepartMent createDepartMent() {
		return new AccessDepartMent();
	}

}
