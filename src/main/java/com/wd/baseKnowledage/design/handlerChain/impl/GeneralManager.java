package com.wd.baseKnowledage.design.handlerChain.impl;

import com.wd.baseKnowledage.design.handlerChain.Manager;
import com.wd.baseKnowledage.design.handlerChain.Request;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月13日 上午8:21:06
* 类说明 总经理
*/
public class GeneralManager extends Manager {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void requestApplication(Request request) {
		if(request.getRequestType().equals("请假")){
			logger.info("{}:请求类型：{},被批准！",name, request.getRequestType());
		}else if(request.getRequestType().equals("加薪")&&request.getNumber()<=500){
			logger.info("{}:请求类型：{},加薪量：{},被批准！",name, request.getRequestType(),request.getNumber());
		}else if(request.getRequestType().equals("加薪")&&request.getNumber()>500){
			try {
				logger.info("{}:加薪数：{}，超过500，需要考虑下",name,request.getNumber());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("请求类型：{},加薪量：{},批准！", request.getRequestType(),request.getNumber());
		}
	}

}
