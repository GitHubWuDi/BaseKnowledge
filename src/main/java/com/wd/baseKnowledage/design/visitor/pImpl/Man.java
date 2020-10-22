package com.wd.baseKnowledage.design.visitor.pImpl;

import com.wd.baseKnowledage.design.visitor.Action;
import com.wd.baseKnowledage.design.visitor.Person;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月22日 上午8:45:04
* 类说明
*/
public class Man extends Person {

	@Override
	public void accept(Action visitor) {
		visitor.getManConclusion(this);		
	}

}
