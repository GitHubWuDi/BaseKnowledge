package com.wd.baseKnowledage.algorithm.list.impl;

import com.wd.baseKnowledage.algorithm.list.model.LNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月27日 上午9:04:07
* 需求说明 : 给定一个带头结点的单链表，请将其逆序。即如果单链表原来为 head→1→2→3→4→5→6→7，则逆序后变为head→7→6→5→4→3→2→1。
*/
public class ReverseTest1 {

	/**
	 * 时间复杂度（O（N））
	 * @param head
	 */
	public static void reverse1(LNode head){
		if(head==null || head.next==null) {
			return;
		}
		LNode pre = null; //前驱节点
		LNode cur = null; //当前节点
		LNode next = null; //后继节点
		//把链表首节点变成尾节点
		cur = head.next; 
		next = cur.next;
		cur.next = null;
		pre = cur;
		cur = next;
		//使用当前遍历到节点cur指向前驱节点
		while(cur.next!=null) {
			next=cur.next;
			cur.next=pre;
			pre = cur;
			cur=cur.next;
			cur=next;
		}
		//结点最后一个结点指向倒数第二个结点
		cur.next = pre;
		//链表的头节点指向原来链表的尾节点
		head.next = cur;
	}

	public static void main(String[] args) {
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
		System.out.println("逆序前：");
		dataOutput(head);
		System.out.println("逆序后：");
		reverse1(head);
		dataOutput(head);
	}

	
	private static void dataOutput(LNode head) {
		LNode cur;
		for (cur = head.next; cur!=null; cur = cur.next) {
			System.out.println(cur.data+"");
		}
	}
	
}
