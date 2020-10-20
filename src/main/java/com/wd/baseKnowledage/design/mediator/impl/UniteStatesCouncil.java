package com.wd.baseKnowledage.design.mediator.impl;

import com.wd.baseKnowledage.design.mediator.Country;
import com.wd.baseKnowledage.design.mediator.UnitedNations;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月20日 下午6:49:10
* 类说明 安理会
*/
public class UniteStatesCouncil extends UnitedNations {
 
	private USA usaColleague1;
	private CHINA chinaColleague1;
	
	
	@Override
	public void declare(String message, Country colleagus) {
		
		if(colleagus instanceof USA) {
			usaColleague1.getMessage(message);
		}else {
			chinaColleague1.getMessage(message);
		}
	}


	public USA getUsaColleague1() {
		return usaColleague1;
	}


	public void setUsaColleague1(USA usaColleague1) {
		this.usaColleague1 = usaColleague1;
	}


	public CHINA getChinaColleague1() {
		return chinaColleague1;
	}


	public void setChinaColleague1(CHINA chinaColleague1) {
		this.chinaColleague1 = chinaColleague1;
	}

	
	
	
	
}
