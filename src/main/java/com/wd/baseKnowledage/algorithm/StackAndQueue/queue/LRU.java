package com.wd.baseKnowledage.algorithm.StackAndQueue.queue;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月27日 上午8:20:52
* 类说明  LRU是Least Recently Used 的缩写，它的意思是“最近最少使用”。LRU缓存就是使用这种原理实现:
* 1）使用双向链表实现的队列，队列的最大容量为缓存的大小。在使用的过程中，把最近使用的页面移动到队列头，最近没有使用的页面将被放在队列尾的位置。
  2）使用一个哈希表，把页号作为键，把缓存在队列中的结点的地址作为值。
     当引用一个页面时，所需的页面在内存中，需要把这个页对应的结点移动到队列的前面。
     如果所需的页面不在内存中，将它存储在内存中。简单地说，就是将一个新结点添加到队列的前面，并在哈希表中更新相应的结点地址。
     如果队列是满的，那么就从队列尾部移除一个结点，并将新结点添加到队列的前面。
*/

import java.util.ArrayDeque;
import java.util.HashSet;


public class LRU {

	
	private int cacheSize;  //缓存的个数
	private ArrayDeque<Integer> queue = new ArrayDeque<>();
	private HashSet<Integer> hashSet = new HashSet<>();
	
	
	public LRU(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	
	/*判断缓存队列是否已经满了*/
	private boolean isQueueFull() {
		return queue.size()==cacheSize;
	}
	
	/*把页号为pageNum的也缓存到队列当中，同时也添加到Hash表中*/
	private void enqueue(int pageNum) {
		if(isQueueFull()) {
			hashSet.remove(queue.getLast()); //从hashSet当中移除队列的最后一个
			queue.pollLast();   //队列移除最后一个
		}
		queue.addFirst(pageNum);
		hashSet.add(pageNum);
	}
	
	/*
	 * 当访问某一个page的时候，会调这个函数，访问该函数存在两种情况
	 * 1.如果page在缓存队列当中，直接把这个节点移动到队首
	 * 2.如果page不在这个队列当中，把这个page缓存到队首
	 * */
	public void accessPage(int pageNum) {
		if(!hashSet.contains(pageNum)) {
			enqueue(pageNum);
		}else if(pageNum!=queue.getFirst()) {  //缓存存在在队列当中，但是不在队首
			queue.remove(pageNum);
			queue.addFirst(pageNum);
		}
	}
	
	
	/**
	 * 打印queue队列
	 */
	public void printQueue() {
		while(!queue.isEmpty()) {
			System.out.println(queue.pop()+"");
		}
	}
	
	
	public static void main(String[] args) {
		LRU lru = new LRU(3);
		lru.accessPage(2);
		lru.accessPage(4);
		lru.accessPage(7);
		lru.accessPage(2);
		System.out.println("经上面排序后的缓存信息");
		lru.printQueue();
	}
	
}
