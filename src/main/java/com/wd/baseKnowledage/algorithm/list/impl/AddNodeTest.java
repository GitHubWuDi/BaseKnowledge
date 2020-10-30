package com.wd.baseKnowledage.algorithm.list.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月30日 上午9:00:30
* 类说明： 给定两个两个单链表，链表的每一个结点代表一位数，计算两个数的和。例如输入链表（3-1-5）和链表（5-9-2），输出8-0-8，即513+295=808，注意个位数在链表头
* ①每组结点进行相加后需要记录其是否有进位；
* ②如果两个链表H1与H2的长度不同（长度分别为L1和L2，且L1＜L2），当对链表的第L1位计算完成后，接下来只需要考虑链表L2剩余的结点的值（需要考虑进位）；
* ③对链表所有结点都完成计算后，还需要考虑此时是否还有进位，如果有进位，则需要增加新的结点，此结点的数据域为1。
*/

import com.wd.baseKnowledage.algorithm.Test;
import com.wd.baseKnowledage.algorithm.list.model.LNode;

public class AddNodeTest {

	
	public static LNode add(LNode h1,LNode h2) {
		if(h1==null||h1.next==null) {
			return h2;
		}
		if(h2==null || h2.next==null) {
			return h1;
		}
		
		
		int c = 0;        //用来记录进位
		int sum = 0;      //用来记录两个结点相加的值
		LNode p1 = h1.next;  //用来遍历h1
		LNode p2 = h2.next;  //用来遍历h2
		LNode tmp = null; //用来指向新创建的存储相加和的结点
		LNode resultHead = new LNode(); //相加后链表头结点
		resultHead.next = null;
		LNode p = resultHead;   //用来指向链表resulthead最后一个结点
		while(p1!=null &&p2!=null) {
			tmp =new LNode();
			tmp.next = null;
			sum=p1.data+p2.data+c;
			tmp.data =sum%10;
			c=sum/10;
			p.next = tmp;
			p = tmp;
			p1 = p1.next;
			p2 = p2.next;
		}
		//链表h2比h1长的时候，接下来只考虑h2剩余结点的值
		if(p1==null) {
			while(p2!=null) {
				tmp =new LNode();
				tmp.next = null;
				sum=p2.data+c;
				tmp.data =sum%10;
				c=sum/10;
				p.next = tmp;
				p = tmp;
				p2 = p2.next;
			}
		}
		//链表h1比h2的时候，接下来只考虑h1剩余结点的值
		if(p2==null) {
			while(p1!=null) {
				tmp =new LNode();
				tmp.next = null;
				sum=p1.data+c;
				tmp.data =sum%10;
				c=sum/10;
				p.next = tmp;
				p = tmp;
				p1 = p1.next;
			}
		}
		
		if(c==1) {
			tmp = new LNode();
			tmp.next = null;
			tmp.data=1;
			p.next =tmp;
		}
		
		return resultHead;
		
	}
	
	
	
	public static void main(String[] args) {
		int i = 1;
		LNode head1 = new LNode();
		head1.next = null;
		LNode head2 = new LNode();
		head2.next = null;
		LNode tmp = null;
		LNode cur = head1;
		LNode addResult  = null;
		for (; i < 7; i++) {
			tmp = new LNode();
			tmp.data= i+2;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
		}
		cur= head2;
		for ( i = 9; i >4; i--) {
			tmp = new LNode();
			tmp.data = i;
			tmp.next = null;
			cur.next = tmp;
			cur = tmp;
		}
        
		System.out.println("head1:");
		Test.dataOutputLnode(head1);
		
		System.out.println("head2:");
		Test.dataOutputLnode(head2);
		
		addResult = add(head1, head2);
		System.out.println("相加后：");
		Test.dataOutputLnode(addResult);
		
	}
	
	
	
}
