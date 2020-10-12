package com.wd.baseKnowledage.design.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午8:45:09
* 类说明    抽象状态类
*/
public abstract class State {
    
	protected Logger logger = LoggerFactory.getLogger(State.class);
	/**
	 * 写程序抽象类
	 * @param work
	 */
	public abstract void writeProgram(Work work);
}
