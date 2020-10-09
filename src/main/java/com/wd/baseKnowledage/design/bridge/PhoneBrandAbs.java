package com.wd.baseKnowledage.design.bridge;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月9日 上午11:17:18
* 类说明   手机品牌
*/
public abstract class PhoneBrandAbs {

	protected  SoftAbs softAbs;
	
	
	public void setSoftAbs(SoftAbs softAbs) {
		this.softAbs = softAbs;
	}
	
	public abstract void run(); //不同手机品牌运行不同的软件   
	
}
