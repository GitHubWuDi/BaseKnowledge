package com.wd.baseKnowledage.algorithm.list.impl;

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.Util;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

/**
 * 
 * @author Administrator
 * 描述：给定链表L0→L1→L2→…→Ln-1→Ln，把链表重新排序为L0→Ln→L1→Ln-1→L2→Ln-2→…。要求：①在原来链表的基础上进行排序，即不能申请新的结点；②只能修改结点的next域，不能修改数据域。
 * 主要思路为：
   1）首先找到链表的中间结点。
   2）对链表的后半部分子链表进行逆序。
   3）把链表的前半部分子链表与逆序后的后半部分子链表进行合并，合并的思路为：分别从两个链表各取一个结点进行合并。实现方法如下图所示。
        整个方法的时间复杂度为O（N）
 * 
 */
public class InsertSequence {

	
	
	
	
	/**
	 * 方法功能：对不带头的节点单链表翻转
	 * @param head
	 * @return
	 */
	private static LNode reverse(LNode head){
		if(head==null || head.next==null) {
			return head;
		}
		LNode pre = head;   //前驱节点
		LNode cur = head.next; //当前节点
		LNode next;   //后继节点
		pre.next = null;
		while(cur!=null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur =cur.next;
			cur = next;
		}
		return pre;
	}
	
	
	/**
	 * 对链表进行插入
	 * @param head
	 */
	public static void reorder(LNode head) {
		if(head==null || head.next==null) {
			return ;
		}
		LNode cur1 = head.next;   //前半部分的第一个节点
		LNode mid = Util.findMiddleNode(head.next); //找到中间一个节点
		LNode cur2 = reverse(mid); //后半部分的第一个节点
		LNode tmp = null;
		//合并两个节点
		while(cur1!=null) {
			tmp = cur1.next;
			cur1.next = cur2;
			cur1 = tmp;
			
			
			tmp = cur2.next;
			cur2.next = cur1;
			cur2 = tmp;
			
		}
		
	}
	
	public static void main(String[] args) {
		LNode head = Util.constructNode();
		System.out.println("排序前：");
		Test.dataOutputLnode(head);
		reorder(head);
		System.out.println("排序后：");
		Test.dataOutputLnode(head);
	}
	
	
	
}
