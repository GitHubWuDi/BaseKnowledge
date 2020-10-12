package com.wd.baseKnowledage.design.state.impl;

import com.wd.baseKnowledage.design.state.State;
import com.wd.baseKnowledage.design.state.Work;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午9:12:54
* 类说明  晚上工作状态
*/
public class EveningState extends State {

	@Override
	public void writeProgram(Work work) {
		if(work.isFinish()) {
			work.setCurrent(new RestState());
			work.writeProgram();
		}else {
			if(work.getHour()<21) {
				logger.info("当前时间：{}，加班哦，疲劳至极", work.getHour());
			}else {
				work.setCurrent(new SleepState());
				work.writeProgram();
			}
		}
	}

}
