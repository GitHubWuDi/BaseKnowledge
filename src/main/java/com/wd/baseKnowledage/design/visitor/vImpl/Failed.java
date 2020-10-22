package com.wd.baseKnowledage.design.visitor.vImpl;

import com.wd.baseKnowledage.design.visitor.Action;
import com.wd.baseKnowledage.design.visitor.pImpl.Man;
import com.wd.baseKnowledage.design.visitor.pImpl.Woman;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月22日 上午8:56:56
* 类说明 失败状态
*/
public class Failed extends Action {

	@Override
	public void getManConclusion(Man visitor) {
		logger.info("每个男人失败都有一个不幸的家庭！");
		
	}

	@Override
	public void getWomanConclusion(Woman visitor) {
		logger.info("每个女人失败都有一个不幸的婚姻！");		
	}

}
