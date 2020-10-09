package com.wd.baseKnowledage.design.bridge.impl;

import com.wd.baseKnowledage.design.bridge.SoftAbs;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:21:36
* 类说明
*/
public class GameSoft implements SoftAbs {

	@Override
	public void run() {
          	System.out.println("游戏软件正在运行！");	
	}

}
