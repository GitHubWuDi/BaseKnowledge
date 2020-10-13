package com.wd.baseKnowledage.design.handlerChain;

import com.wd.baseKnowledage.design.handlerChain.impl.CommonManager;
import com.wd.baseKnowledage.design.handlerChain.impl.GeneralManager;
import com.wd.baseKnowledage.design.handlerChain.impl.Majordomo;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月13日 上午8:33:33
* 类说明
*/
public class Client {

	
	public static void main(String[] args) {
		CommonManager commonManager = new CommonManager("经理");
		Majordomo majordomo = new Majordomo("总监");
		GeneralManager generalManager = new GeneralManager("总经理");
		commonManager.setMananger(majordomo);
		majordomo.setMananger(generalManager);
		
	   Request request1 = new Request();
	   request1.setNumber(2);
	   request1.setRequestType("请假");
	   commonManager.requestApplication(request1);
	   
	   
	   Request request2 = new Request();
	   request2.setNumber(4);
	   request2.setRequestType("请假");
	   commonManager.requestApplication(request2);
		
	   Request request3 = new Request();
	   request3.setNumber(8);
	   request3.setRequestType("请假");
	   commonManager.requestApplication(request3);
	   
	   
	   Request request4 = new Request();
	   request4.setNumber(500);
	   request4.setRequestType("加薪");
	   commonManager.requestApplication(request4);
	   
	   
	   Request request5 = new Request();
	   request5.setNumber(1000);
	   request5.setRequestType("加薪");
	   commonManager.requestApplication(request5);
	   
	  
	}
	
}
