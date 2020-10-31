package com.wd.baseKnowledage.algorithm;

import com.wd.baseKnowledage.algorithm.list.model.LNode;

public class Util {

	
	
	public static LNode constructNode() {
		LNode head  = new LNode();
		head.next = null;
		LNode tmp = null;
		LNode cur  = head;
		for (int i = 0; i < 8; i++) {
			tmp = new LNode();
			tmp.data = i;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
		}
		return head;
			
	}
}
