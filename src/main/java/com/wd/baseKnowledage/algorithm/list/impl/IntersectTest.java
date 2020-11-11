package com.wd.baseKnowledage.algorithm.list.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月11日 上午9:04:59
* 类说明  判断两个链表是否相交，如果相交找出交点
* 实现方法：主要思路：如果两个链表相交，那么两个链表从相交点到链表结束都是相同的结点，必然是Y字形（如上图所示）。
* 所以，判断两个链表的最后一个结点是不是相同即可。
* 1.即先遍历一个链表，直到尾部，
* 2.再遍历另外一个链表，如果也可以走到同样的结尾点，则两个链表相交，这时记下两个链表的长度 n1、n2，再遍历一次，
* 长链表结点先出发前进|n1-n2|步，之后两个链表同时前进，每次一步，相遇的第一点即为两个链表相交的第一个点。实现代码如下：
*/

import com.wd.baseKnowledage.algorithm.Util;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

public class IntersectTest {

	
	/**
	 * 判断两个链表是否相交，如果相交则找出交点
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static LNode isIntersect(LNode head1,LNode head2) {
		if(head1.next==null||head1==null || head2.next==null||head2==null) {
			return null;
		}
		LNode temp1 = head1.next;
		LNode temp2 = head2.next;
		int n1 = 0;
		int n2 = 0;
		while(temp1.next!=null) {
			temp1 = temp1.next;
			++n1;
		}
		while(temp2.next!=null) {
			temp2 = temp2.next;
			++n2;
		}
		if(temp1.data==temp2.data) {   //说明有相同的尾结点
			if(n1>n2) {
				while(n1-n2>0) {
					head1 = head1.next;
					--n1;		
				}
			}
			if(n2>n1) {
				while(n2-n1>0) {
					head2 = head2.next;
					--n2;
				}
			}
			while(head1!=head2) {
				head1 = head1.next;
				head2 = head2.next;
			}
			return head1;
		}else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		LNode head1 = Util.constructNode();
		LNode head2 = Util.constructNode();
		LNode intersect = isIntersect(head1, head2);
		if(intersect==null) {
			System.out.println("不存在交点");
		}else {
		  System.out.println("交点为："+intersect.data);	
		}
	}
	
	
	
}
