package com.wd.baseKnowledage.design.handlerChain.impl;

import com.wd.baseKnowledage.design.handlerChain.Manager;
import com.wd.baseKnowledage.design.handlerChain.Request;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月13日 上午8:21:06
* 类说明 总监
*/
public class Majordomo extends Manager {

	public Majordomo(String name) {
		super(name);
	}

	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("请假")&&request.getNumber()<=5){
			logger.info("{}: 请求类型：{}，请求天数：{},被批准！",name,request.getRequestType(),request.getNumber());
		}else {
			if(mananger!=null) {
				mananger.requestApplication(request);
			}
		}
	}

}
