package com.wd.baseKnowledage.algorithm.list.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月2日 上午9:03:10
* 类说明     如何检测一个较大的单链表是否有环
* 单链表有环指的是单链表中某个结点的next域指向链表中在它之前的某一个结点，这样在链表的尾部形成一个环形结构。如何判断单链表是否有环存在？
* 引申：如果链表存在环，那么如何找出环的入口点？
* 方法二：
* 定义两个指针fast（快）与slow（慢），两者的初始值都指向链表头，指针slow每次前进一步，指针fast每次前进两步。
* 两个指针同时向前移动，快指针每移动一次都要跟慢指针比较，如果快指针等于慢指针，就证明这个链表是带环的单向链表，否则证明这个链表是不带环的循环链表。实现代码见后面引申部分。
* 算法复杂度：
* 
*/

import com.wd.baseKnowledage.algorithm.Util;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

public class CheckRingTest {
       
	/**
	 * 判断单链表是否有环
	 * 输入参数：head链表头节点
	 * 返回值：null，否则返回slow与fast相遇的节点
	 * @param head
	 * @return
	 */
	public static LNode isLoop(LNode head) {
		 if(head==null || head.next ==null) {
			 return head;
		 }
		 LNode fast = head.next;
		 LNode slow = head.next;
		 while(fast!=null&&fast.next!=null) {
			 slow = slow.next;
			 fast = fast.next.next;
			 if(slow==fast) {
				 return slow;
			 }
		 }
		return null;
	}
	
	
	/**
	 * 找出环的入环口
	 * 输入参数：head节点:头节点，meetNode:fast与slow相遇点
	 * @param head
	 * @param meetNode
	 * @return null 无环，否则返回slow与fast指针相遇点的节点
	 */
	public static LNode findLoopNode(LNode head,LNode meetNode) {
		LNode first = head.next;
		LNode second = meetNode;
		while(first!=second) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	public static void main(String[] args) {
		
		LNode head = Util.constructRingNode();
		LNode meetNode = isLoop(head);
		if(meetNode!=null) {
			System.out.println("有环：");
			LNode loopNode = findLoopNode(head, meetNode);
			System.out.println("环的入口点是："+loopNode.data);
		}else {
			System.out.println("无环");
		}
		
		
	}
	
	
	
}
