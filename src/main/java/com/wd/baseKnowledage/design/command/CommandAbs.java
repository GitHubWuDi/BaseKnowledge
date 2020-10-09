package com.wd.baseKnowledage.design.command;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:38:59
* 类说明 命令抽象类
*/
public abstract class CommandAbs {

	protected Receiver receiver;
	
	public CommandAbs(Receiver receiver) {
		this.receiver = receiver;
	}
	
	
	/**
	 * 执行命令的抽象方法
	 */
	public abstract void execute();
	
}
