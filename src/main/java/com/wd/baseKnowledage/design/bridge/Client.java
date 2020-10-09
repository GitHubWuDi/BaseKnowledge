package com.wd.baseKnowledage.design.bridge;

import com.wd.baseKnowledage.design.bridge.impl.CommunicateSoft;
import com.wd.baseKnowledage.design.bridge.impl.GameSoft;
import com.wd.baseKnowledage.design.bridge.impl.PhoneBrandA;
import com.wd.baseKnowledage.design.bridge.impl.PhoneBrandB;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:27:30
* 类说明
*/
public class Client {

	public static void main(String[] args) {
		PhoneBrandAbs phoneBrandAbs = null;
		System.out.println("A品牌手机");
		phoneBrandAbs = new PhoneBrandA();
		phoneBrandAbs.setSoftAbs(new GameSoft());
		phoneBrandAbs.run();
		phoneBrandAbs.setSoftAbs(new CommunicateSoft());
		phoneBrandAbs.run();
		System.out.println("B品牌手机");
		phoneBrandAbs = new PhoneBrandB();
		phoneBrandAbs.setSoftAbs(new GameSoft());
		phoneBrandAbs.run();
		phoneBrandAbs.setSoftAbs(new CommunicateSoft());
		phoneBrandAbs.run();
		
		
	}
	
	
	
}
