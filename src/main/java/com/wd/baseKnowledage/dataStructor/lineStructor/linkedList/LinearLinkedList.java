package com.wd.baseKnowledage.dataStructor.lineStructor.linkedList;

import lombok.Data;

/**
 * 线性表（单链表）
 * @author Administrator
 *
 */
@Data
public class LinearLinkedList<T> {

	private T data;
	private LinearLinkedList<T> next;
	
	
	public LinearLinkedList(LinearLinkedList<T> linearLinkedList) {
		this.next = linearLinkedList;
	}
	
	public LinearLinkedList() {
		
	}
	
	/**
	 * 获得链表的长度
	 * @param headnode
	 * @return
	 */
	public Integer listLength() {
		int length=0;
		LinearLinkedList<T> currentnode = next;
		while(currentnode != null) {
			length++;
			currentnode=currentnode.getNext();
		}
		return length;
	}
	
	/**
	 * 获得对应的元素
	 * @param linearLinkedList
	 * @param i
	 * @return
	 */
	public T getElem(int i) {
		int j=1; //j为计数器
		LinearLinkedList<T> p; /*声明一指针p*/
		p = next.getNext();/*p指向下一个元素*/
		while(p!=null&&j<i) {
			p = p.getNext();
			++j;
		}
		if(p==null||j>i) {
			throw new RuntimeException("error,please check!");
		}
		T t = p.getData();
		return t;
	}
	
	/**
	 * 插入某一个元素
	 * @param linearLinkedList
	 * @param i
	 * @param t
	 */
	public void insertElem(int i,T t) {
		int j=1; //j为计数器
		LinearLinkedList<T> p,s;
		p = next.getNext();
		while(p!=null&&j<i) {
			p = p.getNext();
			++j;
		}
		if(p==null||j>i) {
			throw new RuntimeException("error,please check!");
		}
		//生成一个新节点
		s =new LinearLinkedList<T>();
		s.setData(t);
		//s->next = p->next;
		LinearLinkedList<T> sNext = s.getNext();
		sNext = p.getNext();
		s.setNext(sNext);
		//p-next = s;
		p.setNext(s);
	}
	/**
	 * 删除某一个元素
	 * @param linearLinkedList
	 * @param i
	 */
	public void deleteElem(int i) {
		int j=1; //j为计数器
		LinearLinkedList<T> p;
		p = next.getNext();
		while(p!=null&&j<i) {
			p = p.getNext();
			++j;
		}
		if(p==null||j>i) {
			throw new RuntimeException("error,please check!");
		}
		
		LinearLinkedList<T> pNext = p.getNext();
		LinearLinkedList<T> pNextNext = p.getNext().getNext();
		
		pNext = pNextNext;
		p.setNext(pNext);
	}
	
}
