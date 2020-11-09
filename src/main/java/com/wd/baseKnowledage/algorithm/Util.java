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
	
	
	
	public static LNode dynamicConstructNode(int i) {
		LNode head  = new LNode();
		head.next = null;
		LNode tmp = null;
		LNode cur  = head;
		for (; i < 8; i+=2) {
			tmp = new LNode();
			tmp.data = i;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
		}
		return head;
			
	}
	
	
	/**
	 * 构造环形链表
	 * @return
	 */
	public static LNode constructRingNode(){
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
		cur.next  = head.next.next.next;
		return head;
	}
	
	
	
	
	/**
	 * 找到链表的中间节点
	 * @param head
	 * @return
	 */
	public static LNode findMiddleNode(LNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		LNode fast = head; //遍历链表时每次向前走两步
		LNode slow = head; //遍历链表时每次向前走一步
		LNode slowPre = head;
		//当fast到达链表尾端的时候，slow恰好达到链表的中间
		while(fast!=null&&fast.next!=null) {
			slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
		}
		slowPre.next = null;
		return slow;
	}
	
}
