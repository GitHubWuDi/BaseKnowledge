package com.wd.baseKnowledage.design.bridge.impl;

import com.wd.baseKnowledage.design.bridge.SoftAbs;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:22:55
* 类说明 通信软件
*/
public class CommunicateSoft implements SoftAbs {

	@Override
	public void run() {
        System.out.println("通信软件正在运行！");		
	}

}
