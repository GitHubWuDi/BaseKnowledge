package com.wd.baseKnowledage.callBack;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
* 被调用者
* @author wudi
* @version 创建时间：2018年5月16日 下午10:27:03
* @ClassName 类名称
* @Description 类描述
*/
public class Callee {
     
	public void executionQuestion(CallBack callBack,String question){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = getResultByQuestion(question);
		callBack.solve(result); //被调用者主动调用调用者的callback方法
	}
	
	private String getResultByQuestion(String quesition){
		return "answer:"+"2";
	}
	
	
}
