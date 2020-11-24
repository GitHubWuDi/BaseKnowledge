package com.wd.baseKnowledage.algorithm.StackAndQueue.stack;

import java.util.Stack;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月24日 上午9:12:04
* 类说明：如何用如何用O（1）的时间复杂度求栈中最小元素O（1）的时间复杂度求栈中最小元素
* 一个栈用来存储数据，另外一个栈用来存储栈的最小元素。实现思路如下：
* 如果当前入栈的元素比原来栈中的最小值还小，则把这个值压入保存最小元素的栈中；
* 在出栈时，如果当前出栈的元素恰好为当前栈中的最小值，保存最小值的栈顶元素也出栈，使得当前最小值变为当前最小值入栈之前的那个最小值。为了简单起见，可以在栈中保存int类型。
*/
public class SearchMinElemByO1 {

	//用来存储栈中元素
	private Stack<Integer> elemStack = new Stack<>();
	//栈顶永远存储当前elemStack中最小值
	private Stack<Integer> minStack  = new Stack<>();
	
	/**
	 * 入栈
	 * @param data
	 */
	public void push(int data){
		elemStack.push(data);
		if(minStack.isEmpty()) {
			minStack.push(data);
		}else {
			Integer peek = minStack.peek();
			if(data<peek) {
				minStack.push(data);
			}
		}
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		Integer topData = elemStack.peek();
		elemStack.pop();
		if(topData==min()) {
			minStack.pop();
		}
		return topData;
	}
	
	/**
	 * 获得最小值
	 * @return
	 */
	public int min() {
		if(minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}else {
			return minStack.peek();
		}
	}
	
	public static void main(String[] args) {
		SearchMinElemByO1 searchMinElemByO1 = new SearchMinElemByO1();
		searchMinElemByO1.push(5);
		System.out.println("栈中最小值为："+searchMinElemByO1.min());
		searchMinElemByO1.push(6);
		System.out.println("栈中最小值为："+searchMinElemByO1.min());
		searchMinElemByO1.push(2);
		System.out.println("栈中最小值为："+searchMinElemByO1.min());
	}
	
	
}
