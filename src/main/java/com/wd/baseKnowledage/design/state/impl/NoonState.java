package com.wd.baseKnowledage.design.state.impl;

import com.wd.baseKnowledage.design.state.State;
import com.wd.baseKnowledage.design.state.Work;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午9:04:51
* 类说明
*/
public class NoonState extends State {

	@Override
	public void writeProgram(Work work) {
		int hour = work.getHour();
		if(hour<13) {
			logger.info("当前时间：{}点，饿了，午饭，犯困，午休", hour);
		}else {
			work.setCurrent(new AfternoonState());
			work.writeProgram();
		}

	}

}
