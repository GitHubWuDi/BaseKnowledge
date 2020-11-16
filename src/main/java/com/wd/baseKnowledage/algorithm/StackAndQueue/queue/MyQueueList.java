package com.wd.baseKnowledage.algorithm.StackAndQueue.queue;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月16日 下午6:11:42
* 类说明 链表实现队列的各种基本操作：采用链表实现队列的方法与实现栈的方法类似，分别用两个指针指向队列的首元素与尾元素，如下图所示。用pHead来指向队列的首元素，用pEnd来指向队列的尾元素。
*/

import com.wd.baseKnowledage.algorithm.StackAndQueue.LNode;

public class MyQueueList<T> {
     
	private LNode<T> pHead; //头结点
	private LNode<T> pEnd; //尾结点
	
	public MyQueueList() {
		pHead = pEnd = null;
	}
	
	/**
	 * 是否空
	 * @return
	 */
	public boolean isEmpty() {
		if(pHead==null) {
			return true; //表示为空队列
		}else {
			return false;
		}
	}
	
	
	/**
	 * 队列长度
	 * @return
	 */
	public Integer size() {
		int size = 0;
		LNode<T> p = pHead;
		while(p!=null) {
			p  = p.next;
			size++;
		}
		return size;
		
	}
	
	/**
	 * 插入队列
	 * @param e
	 */
	public void enQueue(T e) {
		LNode<T> newNode  = new LNode<T>();
		newNode.data = e;
		newNode.next = null;
		if(pHead==null) {
			pHead = pEnd = newNode;
		}else {
			pEnd.next = newNode;
			pEnd = newNode;
		}
	}
	
	
	/**
	 * 删除头结点
	 */
	public void delQueue() {
		if(pHead==null) {
			System.out.println("队列已经为空，无需再删除了！");
		}else {
			pHead = pHead.next;
			if(pHead==null) {
				pEnd =null;
			}
		}
	}
	
	
	/**
	 * 获得队列头结点
	 * @return
	 */
	public T getTop() {
		if(pHead==null) {
			System.out.println("队列头结点为空！");
			return null;
		}else {
			return pHead.data;
		}
	}
	
	/**
	 *  获得队列尾结点
	 * @return
	 */
	public T getRear() {
		if(pEnd==null) {
			System.out.println("队列尾结点为空！");
			return null;
		}else {
			return pEnd.data;
		}
	}
	
	public static void main(String[] args) {
		MyQueueList<Integer> myQueueList = new MyQueueList<Integer>();
		myQueueList.enQueue(1);
		myQueueList.enQueue(2);
		System.out.println("队列长度："+myQueueList.size());
		System.out.println("队列头结点："+myQueueList.getTop());
		System.out.println("队列尾结点："+myQueueList.getRear());
		myQueueList.delQueue();
		System.out.println("删除头结点后:");
		System.out.println("队列头结点："+myQueueList.getTop());
		System.out.println("队列尾结点："+myQueueList.getRear());
	}
	
	
}
