package com.wd.baseKnowledage.algorithm.StackAndQueue.stack;

import java.util.ArrayList;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月15日 上午10:30:51
* 题目描述   如何实现栈（数组实现）
* 设计说明: 可以把数组的首元素当作栈底，同时记录栈中元素的个数size，假设数组首地址为arr，压栈的操作其实是把待压栈的元素放到数组arr[size]中，然后执行size++操作；
*        同理，弹栈操作其实是取数组arr[size-1]元素，然后执行size--操作。根据这个原理可以非常容易实现栈，实现代码如下：
*/
public class MyStack<T> {
   
	private ArrayList<T> arr;
	private int stackSize;
	
	public MyStack() {
		arr = new ArrayList<>();
		stackSize = 0;
	}
	
	
	public boolean isEmpty() {
		return stackSize == 0;
	}

	/**
	 * 返回栈顶元素
	 * @return
	 */
	public T top() {
		return arr.get(stackSize-1);
	}
	
	
	/**
	 * 弹栈
	 * @return
	 */
	public T pop() {
		if(stackSize>0) {
			return arr.get(--stackSize);
		}else {
			System.out.println("栈已经空了，请检查！");
			return null;
		}
	}
	
	
	/**
	 * 压栈
	 * @param t
	 */
	public void push(T t) {
		arr.add(t);
		stackSize++;
	}
	
	
	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<>();
		myStack.push(1); //压入元素1
		myStack.push(2); //压入元素2
		Integer top = myStack.top();
		System.out.println("栈顶元素是："+top);
		Integer pop = myStack.pop(); //弹出元素1
		System.out.println("弹出元素是："+pop);
		Integer top1 = myStack.top();
		System.out.println("弹出元素后栈顶元素是："+top1);
	}
	
	
	
}
