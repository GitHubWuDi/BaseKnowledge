package com.wd.baseKnowledage.design.command;

import java.util.ArrayList;
import java.util.List;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:52:11
* 类说明    传递执行命令者
*/
public class WaiterInvoker {

	private List<CommandAbs> commands = new ArrayList<>();
	
	
    /**
     * 设置命令	
     * @param commandAbs
     */
	public void  setOrder(CommandAbs commandAbs) {
		commands.add(commandAbs); //增加订单
	}
	
	/**
	 * 取消命令 
	 * @param commandAbs
	 */
	public void cancelOrder(CommandAbs commandAbs) {
		commands.remove(commandAbs);
	}
	
	public void notifyCommand() {
		for (CommandAbs commandAbs : commands) {
			commandAbs.execute();
		}
	}
	
	
	
}
