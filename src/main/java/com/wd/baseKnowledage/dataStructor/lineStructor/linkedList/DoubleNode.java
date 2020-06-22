package com.wd.baseKnowledage.dataStructor.lineStructor.linkedList;

/**
 * 双向链表
 * @author Administrator
 *
 */
public class DoubleNode<T> {

	private T data;
	private DoubleNode<T> next; //后继指针
	private DoubleNode<T> prior; //前驱指针
	
	public DoubleNode(DoubleNode<T> next,DoubleNode<T> prior,T data) {
		this.next = next;
		this.prior  = prior;
		this.data = data;
	}
	
	public DoubleNode() {
		
	}
	
	public DoubleNode(DoubleNode<T> next) {
		this.next = next;
	}
	
	
	/**
	 * 双向链表插入
	 * @param i
	 * @param t
	 */
	public void insertElem(int i,T t) {
		int j = 1;
		DoubleNode<T> n,s; //n是后继指针，p是前驱指针，s是准备初始化的新节点
		n = next.getNext();
		s = new DoubleNode<T>();
		s.setData(t);
		while(n!=null&&j<i) {
			n = n.getNext();
			++j;
		}
		if(n==null||j>i) {
			throw new RuntimeException("error,please check!");
		}
		
		s.setPrior(n);  //1
		s.setNext(n.getNext());//2
		s.getPrior().setNext(s);
		//n.getNext().setPrior(s);
		n.setNext(s);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public DoubleNode<T> getPrior() {
		return prior;
	}

	public void setPrior(DoubleNode<T> prior) {
		this.prior = prior;
	}
	
	
	
	
}
