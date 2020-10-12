package com.wd.baseKnowledage.design.state.impl;

import com.wd.baseKnowledage.design.state.State;
import com.wd.baseKnowledage.design.state.Work;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午9:17:42
* 类说明
*/
public class SleepState extends State {

	@Override
	public void writeProgram(Work work) {
		logger.info("当前时间：{}点,不行了，要睡着了！", work.getHour());
	}

}
