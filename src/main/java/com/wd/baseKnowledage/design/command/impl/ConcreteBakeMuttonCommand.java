package com.wd.baseKnowledage.design.command.impl;

import com.wd.baseKnowledage.design.command.CommandAbs;
import com.wd.baseKnowledage.design.command.Receiver;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:48:24
* 类说明
*/
public class ConcreteBakeMuttonCommand extends CommandAbs {

	public ConcreteBakeMuttonCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.bakeMutton();
	}

}
