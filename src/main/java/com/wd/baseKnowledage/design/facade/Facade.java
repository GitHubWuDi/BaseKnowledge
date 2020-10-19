package com.wd.baseKnowledage.design.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.baseKnowledage.design.facade.sub.SubSystemFour;
import com.wd.baseKnowledage.design.facade.sub.SubSystemOne;
import com.wd.baseKnowledage.design.facade.sub.SubSystemThree;
import com.wd.baseKnowledage.design.facade.sub.SubSystemTwo;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月19日 下午6:57:21
* 类说明 外观类
*/
public class Facade {

	private static Logger logger  = LoggerFactory.getLogger(Facade.class);
	
	private SubSystemOne subSystemOne;
	private SubSystemTwo subSystemTwo;
	private SubSystemThree subSystemThree;
	private SubSystemFour subSystemFour;
	
	public Facade() {
		subSystemOne = new SubSystemOne();
		subSystemTwo = new SubSystemTwo();
		subSystemThree = new SubSystemThree();
		subSystemFour = new SubSystemFour();
	}
	
	public void method1() {
		subSystemOne.methodA();
		subSystemTwo.methodB();
	}
	
	public void method2() {
		subSystemThree.methodC();
		subSystemFour.methodE();
	}
	
	
	
}
