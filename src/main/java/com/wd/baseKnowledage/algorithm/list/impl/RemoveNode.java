package com.wd.baseKnowledage.algorithm.list.impl;

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月10日 上午9:11:52
* 类说明 ：如何在只给定单链表中某个结点的指针的情况下删除该结点
* 题目描述：假设给定链表1→2→3→4→5→6→7中指向第5个元素的指针，要求把结点5删掉，删除后链表变为1→2→3→4→6→7。
* 算法性能分析：
* 由于这种方法不需要遍历链表，只需要完成一个数据复制与结点删除的操作，因此，时间复杂度为O（1）。由于这种方法只用了常数个额外指针变量，因此，空间复杂度也为O（1）。
*/

public class RemoveNode {

	
	/**
	 * 只知道当前指针节点的删除
	 * @param p
	 * @return
	 */
	public static boolean remove(LNode p) {
		if(p==null || p.next==null) {
			return false; //如果结点为空，或结点p无后继结点，则无法删除
		}
		p.data = p.next.data;
		LNode tmp = p.next;
		p.next = tmp.next;
		return true;
	}
	
	
	/**
	 * 单链表某个结点p（非空结点），如何在p后面插入一个结点
	 * @param p
	 * @return
	 */
	public static boolean insertAfter(LNode p,LNode q) {
		if(p==null || p.next==null) {
			return false; //如果结点为空，或结点p无后继结点，则无法删除
		}
		LNode tmp = p.next;
		p.next=q;
		q.next = tmp;
		
		return true;
	}
	
	
	
	/**
	 *TODO 单链表某个结点p（非空结点），如何在p前面插入一个结点
	 * @param p
	 * @return
	 */
	public static boolean insertBefore(LNode p,LNode q) {
		if(p==null || p.next==null) {
			return false; //如果结点为空，或结点p无后继结点，则无法删除
		}
		LNode tmp = p.next;
		p.next = q;
		q.data = p.data;
		q.next = p;
		p.next = tmp;
		return true;
	}
	
	
	
	public static void main(String[] args) {
		//removeNodeTest();
		insertNodeTest();
	}


	/**
	 * 删除指针域结点
	 */
	private static void removeNodeTest() {
		LNode head  = new LNode();
		head.next = null;
		LNode tmp = null;
		LNode cur  = head;
		LNode p = null;
		for (int i = 0; i < 8; i++) {
			tmp = new LNode();
			tmp.data = i;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
			if(i==5) {
				p = tmp;
			}
		}
		int s =p.data;
		System.out.println("删除结点"+s+"前链表：");
		Test.dataOutputLnode(head);
		boolean remove = remove(p);
		if(remove) {
			System.out.println("删除结点"+s+"后台后链表：");
			Test.dataOutputLnode(head);
		}
	}
	
	
	
	private static void insertNodeTest() {
		LNode head  = new LNode();
		head.next = null;
		LNode tmp = null;
		LNode cur  = head;
		LNode p = null;
		for (int i = 0; i < 8; i++) {
			tmp = new LNode();
			tmp.data = i;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
			if(i==5) {
				p = tmp;
			}
		}
		int s =p.data;
		System.out.println("插入结点"+s+"前链表：");
		Test.dataOutputLnode(head);
		LNode q = new LNode();
		q.data = 3;
		boolean remove = insertBefore(p, q);
		if(remove) {
			System.out.println("插入结点"+s+"后台后链表：");
			Test.dataOutputLnode(head);
		}
	}
	
	
	
}
