package com.wd.baseKnowledage.design.visitor.pImpl;

import com.wd.baseKnowledage.design.visitor.Action;
import com.wd.baseKnowledage.design.visitor.Person;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月22日 上午8:46:11
* 类说明
*/
public class Woman extends Person {

	@Override
	public void accept(Action visitor) {
		visitor.getWomanConclusion(this);
	}

}
