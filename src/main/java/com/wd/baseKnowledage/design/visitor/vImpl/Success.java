package com.wd.baseKnowledage.design.visitor.vImpl;

import com.wd.baseKnowledage.design.visitor.Action;
import com.wd.baseKnowledage.design.visitor.pImpl.Man;
import com.wd.baseKnowledage.design.visitor.pImpl.Woman;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月22日 上午8:50:57
* 类说明 成功状态
*/
public class Success extends Action {

	@Override
	public void getManConclusion(Man visitor) {
		logger.info("每个男人成功时，背后都有一个伟大的女人！");
	}

	@Override
	public void getWomanConclusion(Woman visitor) {
		logger.info("每个女人成功时，背后都有一个伟大的男人！");
	}

}
