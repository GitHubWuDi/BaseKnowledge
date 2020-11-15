package com.wd.baseKnowledage.algorithm.StackAndQueue.list;

import com.wd.baseKnowledage.algorithm.Util;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月15日 上午10:55:50
* 类说明 链表实现栈
*/
public class MyStackList<T> {

	private LNode<T> pHead;
	public MyStackList() {
		pHead = new LNode<>();
		pHead.data = null;
		pHead.next = null;
	}
	
	public boolean empty() {
		return pHead==null;
	}
	
	public int size() {
		int size = 0;
		LNode<T> p = pHead.next;
		while(p!=null) {
			p=p.next;
			size++;
		}
		return size;
	}
	
	/**
	 * 返回栈顶元素
	 * @return
	 */
	public T top() {
		return  pHead.next.data;
	}
	
	public void push(T e) {
		LNode<T> t = new LNode<>();
		t.data = e;
		t.next = pHead.next;
		pHead.next = t;
	}
	
    public T pop() {
    	LNode<T> tmp = pHead.next;
    	if(tmp!=null) {
    		pHead.next = tmp.next;
    		return tmp.data;
    	}
    	System.out.println("该栈为空栈");
    	return null;
    }	
    
    public static void main(String[] args) {
    	MyStackList<Integer> stackList = new MyStackList<>();
    	stackList.push(1);
    	Integer top = stackList.top();
    	System.out.println("栈顶元素是："+top);
    	stackList.pop();
    	System.out.println("弹栈成功！");
    	stackList.pop();
	}
    
    
    
}
