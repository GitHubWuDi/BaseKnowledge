package com.wd.baseKnowledage.algorithm.StackAndQueue.stack;

import java.util.Stack;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月25日 上午8:16:49
* 类说明 两个栈模拟队列
* 要入队列，入栈 A 即可，而出队列则需要分两种情况考虑：
1）如果栈B不为空，则直接弹出栈B的数据。
2）如果栈B为空，则依次弹出栈A的数据，放入栈B中，再弹出栈B的数据。
*/
public class TwoStacksimulationQueue {

	
	private Stack<Integer> aStack = new Stack<>();  //用来实现入队列的功能
	private Stack<Integer> bStack = new Stack<>();  //用来实现出队列的功能
	
	public void push(Integer elem) {
		aStack.push(elem);
	}
	
	
	public Integer pop() {
		
		if(bStack.isEmpty()){
			while(!aStack.isEmpty()) {
				Integer pop = aStack.pop();
				bStack.push(pop);
			}
		}
		Integer peek = bStack.pop();
		return peek;
	}
	

	
	public static void main(String[] args) {
		TwoStacksimulationQueue squeue = new TwoStacksimulationQueue();
		squeue.push(1);
		squeue.push(2);
		System.out.println("队列首元素："+squeue.pop());
		System.out.println("队列首元素："+squeue.pop());
	}
	
	
	
}
