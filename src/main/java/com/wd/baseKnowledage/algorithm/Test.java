package com.wd.baseKnowledage.algorithm;

import com.wd.baseKnowledage.algorithm.list.model.LNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月26日 下午5:58:33
* 类说明
*/
public class Test {
   
	public static void dataOutputLnode(LNode head) {
		LNode cur;
		for (cur = head.next; cur!=null; cur = cur.next) {
			System.out.println(cur.data+"");
		}
	}
	
	
	
}
