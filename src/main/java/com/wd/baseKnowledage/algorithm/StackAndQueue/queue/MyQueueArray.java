package com.wd.baseKnowledage.algorithm.StackAndQueue.queue;

import java.util.ArrayList;
import java.util.List;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月16日 下午5:47:43
* 类说明
* 实现一个队列的数据结构，使其具有入队列、出队列、查看队列首尾元素、查看队列大小等功能。
* 数组实现
* ，用front来记录队列首元素的位置，用rear来记录队列尾元素往后一个位置。入队列的时候只需要将待入队列的元素放到数组下标为rear的位置，同时执行rear++，出队列的时候只需要执行front++即可。
*/
public class MyQueueArray<T> {

	private List<T> arr = new ArrayList<>();
	private int front; //队列头
	private int rear; //队列尾
	
	public MyQueueArray() {
		front  = 0;
		rear = 0;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	
	public Integer size() {
		return rear-front;
	}
	
	
	/**
	 * 获得头结点
	 * @return
	 */
	public T getFront(){
		if(isEmpty()) {
			return null;
		}else {
			return arr.get(front);
		}
	}
	
	/**
	 * 获得尾结点
	 * @return
	 */
	public T getRear(){
		if(isEmpty()) {
			return null;
		}else {
			return arr.get(rear-1);
		}
	}
	/**
	 * 队列头结点出队列
	 */
	public void deQueue() {
		if(rear>front) {
			front++;
		}else {
			System.out.println("队列为空");
		}
	}
	
	
	/**
	 * 队列加入元素
	 */
	public void pushQueue(T e) {
		arr.add(e);
		rear++;
	}
	
	
	public static void main(String[] args) {
		MyQueueArray<Integer> myQueueArray = new MyQueueArray<Integer>();
		myQueueArray.pushQueue(1);
		myQueueArray.pushQueue(2);
		System.out.println("队列的首结点："+myQueueArray.getFront());
		System.out.println("队列的尾结点："+myQueueArray.getRear());
		myQueueArray.deQueue();
		System.out.println("删除队列首结点后，队列头结点："+myQueueArray.getFront());
	}
	
	
}
