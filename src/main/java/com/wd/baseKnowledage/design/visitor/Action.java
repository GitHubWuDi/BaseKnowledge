package com.wd.baseKnowledage.design.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.baseKnowledage.design.visitor.pImpl.Man;
import com.wd.baseKnowledage.design.visitor.pImpl.Woman;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月22日 上午8:43:28
* 类说明
*/
public abstract class Action {

	protected static Logger logger  = LoggerFactory.getLogger(Action.class);
	
	/**
	 * 获得男人结论或反应
	 * @param visitor
	 */
	public abstract void getManConclusion(Man visitor);
	
	/**
	 * 获得女人结论或反应
	 * @param visitor
	 */
	public abstract void getWomanConclusion(Woman visitor);
	
	
}
