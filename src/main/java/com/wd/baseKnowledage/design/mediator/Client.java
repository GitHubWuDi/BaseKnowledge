package com.wd.baseKnowledage.design.mediator;

import com.wd.baseKnowledage.design.mediator.impl.CHINA;
import com.wd.baseKnowledage.design.mediator.impl.USA;
import com.wd.baseKnowledage.design.mediator.impl.UniteStatesCouncil;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月20日 下午6:54:15
* 类说明
*/
public class Client {

	public static void main(String[] args) {
		UniteStatesCouncil uniteStatesCouncil = new UniteStatesCouncil();
		USA usa = new USA(uniteStatesCouncil);
		CHINA china = new CHINA(uniteStatesCouncil);
		uniteStatesCouncil.setChinaColleague1(china);
		uniteStatesCouncil.setUsaColleague1(usa);
		usa.declare("make American again!");
		china.declare("抗美援朝！");
	}
	
	
}
