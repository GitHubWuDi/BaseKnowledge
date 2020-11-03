package com.wd.baseKnowledage.algorithm.list.impl;

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.Util;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月3日 上午8:52:35
* 类说明
* 如何把链表相邻元素翻转
* 把链表相邻元素翻转，如给定链表为1→2→3→4→5→6→7，则翻转后的链表变为2→1→4→3→6→5→7。
* 解题思路
* 主要思路：通过调整结点指针域的指向来直接调换相邻的两个结点。
* 如果单链表恰好有偶数个结点，那么只需要将奇偶结点对调即可，如果链表有奇数个结点，那么只需要将除最后一个结点外的其他结点进行奇偶对调即可。
* 
*/
public class ReverseTest2 {

	
	public static void reverse2(LNode head) {
		if(head==null ||head.next==null) {
			return ;
		}
		LNode cur = head.next;
		LNode pre = head;
		LNode next = null;
		while(cur!=null &&cur.next!=null){
			next = cur.next.next;    //见图（1）
			pre.next = cur.next;    //见图（2）
			cur.next.next=cur;     //见图（3）
			cur.next=next;        //见图（4）
			pre = cur;           //见图（5）
			cur = next;         //见图（6）
		}
	}
	
	
	public static void main(String[] args) {
		LNode head = Util.constructNode();
		System.out.println("逆转前：");
		Test.dataOutputLnode(head);
		reverse2(head);
		System.out.println("逆转后：");
		Test.dataOutputLnode(head);
	}
	
}
