package com.wd.baseKnowledage.algorithm.list.impl;

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.Util;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

/**
   * 题目描述：如何找出单链表中的倒数第k个元素
    *  找出单链表中的倒数第k个元素，如给定单链表：1→2→3→4→5→6→7，则单链表的倒数第k=3个元素为5。
   * 解题方案：
   * 由于单链表只能从头到尾依次访问链表的各个结点，因此如果要找单链表的倒数第k 个元素，也只能从头到尾进行遍历查找。
   * 在查找过程中，设置两个指针，让其中一个指针比另外一个指针先前移k步，然后两个指针同时往前移动。循环直到先行的指针值为null时，另一个指针所指的位置就是所要找的位置。
   * 算法性能：这种方法只需要对链表进行一次遍历，因此，时间复杂度为O（N）。另外，由于只需要常量个指针变量来保存结点的地址信息，因此，空间复杂度为O（1）。  
 * @author Administrator
 *
 */
public class LNodeFindKElement {

	
	/**
	 *      找出链表倒数第K个节点
	 * @param head
	 * @param k
	 * @return
	 */
	public static LNode findLastK(LNode head,int k) {
		if(head==null||head.next==null) {
			return head;
		}
		LNode slow,fast;
		slow = fast = head.next;
		
		//快指针比慢指针快k步
		int i = 0 ;
		for ( i = 0; i < k && fast!=null; i++) {
			fast = fast.next;
		}
		
		//判断k是否超过链表长度
		if(i<k){
			return null;
		}
		while(fast!=null){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	
	/**
	   引申功能，将链表右旋转k个元素
	 * ①首先找到链表倒数第k+1个结点slow和尾结点fast（如下图所示）
	 * ②把链表断开为两个子链表，其中后半部分子链表结点的个数为k
	 * ③使原链表的尾结点指向链表的第一个结点
	 * ④使链表的头结点指向原链表倒数第k个结点。
	 * @return
	 */
	public static void rotateK(LNode head,int k){
		if(head==null || head.next==null) {
			return ;
		}
		LNode slow,fast,tmp;
		slow = fast = head.next;
		int i;
		for (i = 0; i < k&&fast!=null; i++) {
			fast = fast.next;
		}
		//判断快指针是否超过边界
		if(i<k) {
			return ;
		}
		while(fast.next!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		tmp = slow;
		slow = slow.next;
		tmp.next = null ; //②把链表断开为两个子链表，其中后半部分子链表结点的个数为k
		fast.next = head.next; //③使原链表的尾结点指向链表的第一个结点
		head.next=slow; //④使链表的头结点指向原链表倒数第k个结点。
	}
	
	
	
	public static void main(String[] args) {
		LNode constructNode = Util.constructNode();
		System.out.println("链表元素：");
		Test.dataOutputLnode(constructNode);
//		LNode findLastK = findLastK(constructNode, 3);
//		System.out.println("链表倒数第三个元素："+findLastK.data);
		rotateK(constructNode, 3);
		System.out.println("链表元素右旋转3个元素后：");
		Test.dataOutputLnode(constructNode);
	}
	
	
	
}
