package com.wd.baseKnowledage.design.component;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午11:39:25
* 类说明
*/
public class Util {

	
	public static String getDepth(int depth) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			str.append("-");
		}
		return str.toString();
	}
	
}
