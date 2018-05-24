package com.wd.baseKnowledage.webservice;


import javax.xml.ws.Endpoint;

import org.springframework.stereotype.Component;

/**
* @author wudi
* @version 创建时间：2018年5月22日 下午10:46:27
* @ClassName 类名称
* @Description web_service 发布服务
*/
@Component
public class WebServicePublish {
   
	public void publishWebService(){
		String address = "http://localhost:8989/WS_Server/Webservice";
		Endpoint.publish(address, new WebServiceImpl());
	}
	
	
	
	public static void main(String[] args) {
		new WebServicePublish().publishWebService();
	}
	
}
