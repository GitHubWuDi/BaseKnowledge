package com.wd.baseKnowledage.design.bridge.impl;

import com.wd.baseKnowledage.design.bridge.PhoneBrandAbs;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:24:13
* 类说明  
*/
public class PhoneBrandB extends PhoneBrandAbs {

	@Override
	public void run() {
		softAbs.run();	
	}

}
