package com.wd.baseKnowledage.design.command;

import com.wd.baseKnowledage.design.command.impl.ConcreteBakeChickenWingsCommand;
import com.wd.baseKnowledage.design.command.impl.ConcreteBakeMuttonCommand;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:55:44
* 类说明
*/
public class Client {

	
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
	    CommandAbs bakeChickenWingsCommand = new ConcreteBakeChickenWingsCommand(receiver);	
	    CommandAbs bakeMuttonsCommand = new ConcreteBakeMuttonCommand(receiver);
	    
	    WaiterInvoker waiterInvoker = new WaiterInvoker();
	    waiterInvoker.setOrder(bakeMuttonsCommand);
	    waiterInvoker.setOrder(bakeChickenWingsCommand);
	    waiterInvoker.notifyCommand();
	    
	}
	
	
}
