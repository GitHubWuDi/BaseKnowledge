package com.wd.baseKnowledage.algorithm.list.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月9日 下午6:56:27
* 类说明
* 题目描述：已知两个链表 head1 和 head2 各自有序（如升序排列），请把它们合并成一个链表，要求合并后的链表依然有序。
* 分别用指针head1、head2来遍历两个链表，如果当前head1指向的数据小于head2指向的数据，则将 head1 指向的结点归入合并后的链表中，
* 否则将 head2 指向的结点归入合并后的链表中。如果有一个链表遍历结束，则把未结束的链表连接到合并后的链表尾部。
*/

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.Util;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

public class MergeTwoList {

	
	
	public static LNode merge(LNode head1,LNode head2) {
		if(head1==null || head1.next==null) {
			return head2;
		}
		if(head2==null || head2.next==null) {
			return head1;
		}
		
		LNode cur1 = head1.next;
		LNode cur2 = head2.next;
		
		LNode head = null;    //合并后的头节点
		LNode cur=null;
		
		//合并后链表的头节点为第一个节点元素的那个链表的头节点
		if(cur1.data>cur2.data) {
			head = head2;
			cur = cur2;
			cur2 = cur2.next;
		}else {
			head = head1;
			cur = cur1;
			cur1 = cur1.next;
		}
		//每次找链表剩余的节点的最小值对应的节点接连合并后链表的尾部
		while(cur1!=null&&cur2!=null) {
			if(cur1.data<cur2.data) {
				cur.next = cur1;
				cur = cur1;
				cur1 = cur1.next;
			}else {
				cur.next = cur2;
				cur = cur2;
				cur2 = cur2.next;
			}
		}
		
		if(cur1!=null) {
			cur.next = cur1;
		}
		if(cur2!=null) {
			cur.next = cur2;
		}
		return head;
	}
	
	
	
	public static void main(String[] args) {
		LNode head1 = Util.dynamicConstructNode(0);
		LNode head2 = Util.dynamicConstructNode(1);
		System.out.println("head1:");
		Test.dataOutputLnode(head1);
		System.out.println("head2:");
		Test.dataOutputLnode(head2);
		System.out.println("merge:");
		LNode merge = MergeTwoList.merge(head1, head2);
		Test.dataOutputLnode(merge);
	}
	
	
}
