package com.wd.baseKnowledage.design.state.impl;

import com.wd.baseKnowledage.design.state.State;
import com.wd.baseKnowledage.design.state.Work;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午9:10:07
* 类说明
*/
public class AfternoonState extends State {

	@Override
	public void writeProgram(Work work){
		int hour = work.getHour();
		if(hour<17) {
			logger.info("当前时间：：{}点，下午状态还不错，继续努力", hour);
		}else {
			work.setCurrent(new EveningState());
			work.writeProgram();
		}
	}

}
