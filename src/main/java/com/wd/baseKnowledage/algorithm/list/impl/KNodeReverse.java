package com.wd.baseKnowledage.algorithm.list.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月5日 上午9:36:43
* 类说明 如何把链表以K个节点进行一组翻转
* 题目描述：K链表翻转是指把每K个相邻的结点看成一组进行翻转，如果剩余结点不足K个，则保持不变。
* 假设给定链表1→2→3→4→5→6→7和一个数K，如果K的值为2，那么翻转后的链表为2→1→4→3→6→5→7。如果K的值为3，那么翻转后的链表为3→2→1→6→5→4→7。
* 1）首先设置pre指向头结点，然后让begin指向链表第一个结点，找到从begin开始第K=3个结点end。
  2）为了采用 1.1 节中链表翻转的算法，需要使 end.next=null，在此之前需要记录下 end指向的结点，用pNext来记录。
  3）使end.next=null，使得从begin到end为一个单独的子链表，从而可以对这个子链表采用1.1节介绍的方法进行翻转。
  4）对以begin为第一个结点，end为尾结点所对应的K=3个结点进行翻转。
  5）由于翻转后子链表的第一个结点从begin变为end，因此，执行pre.next=end，把翻转后的子链表链接起来。
  6）把链表中剩余的还未完成翻转的子链表链接到已完成翻转的子链表后面（主要是针对剩余的结点的个数小于K的情况）。
  7）让pre指针指向已完成翻转的链表的最后一个结点。
  8）让begin指针指向下一个需要被翻转的子链表的第一个结点（通过begin=pNext来实现）。
*/

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.Util;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

public class KNodeReverse {
     
	public static LNode reverse(LNode head) {
		if(head==null ||head.next==null) {
			return head;
		}
		LNode pre=head;
		LNode cur = head.next;
		LNode next = cur.next;
		pre.next = null;
		
		while(cur!=null) {
			next =cur.next;
			cur.next = pre;
			pre = cur;
			cur =cur.next;
			cur= next;
		}
		return pre;
		
	}
	
	
	public static void reverseK(LNode head,int k) {
		if(head==null || head.next==null ||k<2) {
			return;
		}
		
		int i=1;
		LNode pre = head;
		LNode begin = head.next;
		LNode end = null;
		LNode pNext = null;
		while(begin!=null) {
			end  = begin;
			for (; i < k; i++) {
				if(end.next!=null) {
					end = end.next;
				}else {
					return;
				}
			}
			pNext = end.next;   //(2)
			end.next = null;    //(3)
			pre.next = reverse(begin); //4,5
			begin.next = pNext; //6
			pre = begin;  //7
			begin = pNext; //8
			i = 1;
		}
		
				
	}
	
	public static void main(String[] args) {
		LNode head = Util.constructNode();
		System.out.println("翻转3个元素前：");
		Test.dataOutputLnode(head);
		System.out.println("翻转3个元素后：");
		reverseK(head, 3);
		Test.dataOutputLnode(head);
	}
	
	
}
