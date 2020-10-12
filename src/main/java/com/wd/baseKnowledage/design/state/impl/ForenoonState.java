package com.wd.baseKnowledage.design.state.impl;

import com.wd.baseKnowledage.design.state.State;
import com.wd.baseKnowledage.design.state.Work;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午8:54:15
* 类说明：早上工作状态
*/
public class ForenoonState extends State {

	@Override
	public void writeProgram(Work work) {
		int hour = work.getHour();
		if(hour<12) {
			logger.info("当前时间：{}点， 上午工作，精神百倍", hour);
		}else {
			work.setCurrent(new NoonState());
			work.writeProgram();
		}
	}

}
