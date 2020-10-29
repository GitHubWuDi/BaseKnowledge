package com.wd.baseKnowledage.algorithm.list.impl;

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月28日 下午3:30:32
* 需求： 如何从无序链表中移除重复项  时间复杂度:O(N 2),O(1)
*/
public class RemoveDup {
   
	/**
	 * 顺序删除
	 * @param head
	 */
	public static void removeDup1(LNode head) {
		if(head==null || head.next==null) {
			return;
		}
		LNode outerCur = head.next; //用于外层循环，指向链表第一个结点
		LNode innerCur = null;   //内层循环用来遍历outerCur后面的结点
		LNode innerPre = null; //innerCur的前驱结点
		for (; outerCur!=null;outerCur = outerCur.next) {
			for (innerCur = outerCur.next,innerPre=outerCur;innerCur!=null;) {
				if(outerCur.data == innerCur.data) {
					innerPre.next = innerCur.next;
					innerCur = innerCur.next;
				}else {
					innerPre = innerCur;
					innerCur = innerCur.next;
				}
			}
		}
	}
	
	
	
	/**
	 * 递归删除
	 * @param head
	 * @return
	 */
	private static LNode removeDupRecursion(LNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		LNode pointer = null;
		LNode cur = head;
		//对以head.next为首的子链表删除重复的结点
		pointer = head.next;
		//找出以head.next为首的子链表中与head结点相同的结点并删除
		while(pointer!=null) {
			if(head.data ==pointer.data) {
				cur.next = pointer.next;
				pointer = cur.next;
			}else {
				pointer = pointer.next;
				cur=cur.next;
			}
		}
		head.next = removeDupRecursion(head.next);
		return head;
		
	} 
	
	
	public static LNode removeDup2(LNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		return head.next = removeDupRecursion(head.next);
	}
	
	
	
	public static void main(String[] args) {
		LNode head  = new LNode();
		head.next = null;
		LNode tmp = null;
		LNode cur  = head;
		for (int i = 0; i < 3; i++) {
			tmp = new LNode();
			tmp.data = i;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
		}
		for (int i = 0; i < 3; i++) {
			tmp = new LNode();
			tmp.data = i;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
		}
		System.out.println("去重前：");
		Test.dataOutputLnode(head);
		
		//removeDup1(head);
		removeDup2(head);
		System.out.println("去重后：");
		Test.dataOutputLnode(head);
	}
	
	
	
	
}
