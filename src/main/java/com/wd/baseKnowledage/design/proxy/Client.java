package com.wd.baseKnowledage.design.proxy;

import com.wd.baseKnowledage.design.proxy.impl.Proxy;
import com.wd.baseKnowledage.design.proxy.impl.SchoolGril;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月21日 上午9:28:04
* 类说明
*/
public class Client {

	public static void main(String[] args) {
		SchoolGril schoolGril = new SchoolGril();
		schoolGril.setName("可可");
		Proxy proxy = new Proxy(schoolGril);
		proxy.giveDolls();
		proxy.giveFlower();
		proxy.giveCholocate();
	}
}
