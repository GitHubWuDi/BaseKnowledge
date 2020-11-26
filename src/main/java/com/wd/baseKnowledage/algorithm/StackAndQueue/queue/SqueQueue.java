package com.wd.baseKnowledage.algorithm.StackAndQueue.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月26日 上午8:17:40
* 类说明    如何设计一个排序队列
* 设计一个排队系统，能够让每个进入队的用户都能看到自己在队列中所处的位置和变化，队可能随时有人加入和退出；当有人退出影响到用户的位置排名时需要及时反馈到用户。
* 本题不仅要实现队列常见的入队列与出队列的功能，而且还需要实现队列中任意一个元素都可以随时出队列，且出队列后需要更新队列用户位置的变化。
*/
public class SqueQueue {

	
	
	
	public static class User{
		
		public User(int id,String name) {
			this.id = id;
			this.name = name;
		}
		
		
		private int id;
		private String name;
		private int seq;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
		
	   public boolean equals(Object arg) {
		   User o = (User)arg;
		   return this.id == o.getId();
	   }
	   
	   public String toString() {
		   return "id="+id+",name="+name+",seq="+seq;
	   }
	}
	
	static class Myqueue{
		private Queue<User> q = new LinkedList<>();
		
		/**
		 * 入队列
		 * @param user
		 */
		public void enqueue(User user) {
			user.setSeq(q.size()+1);
			q.add(user);
		}
		
		/**
		 * 删除队头元素
		 */
		public void deQueue() {
			q.poll();
			updateSeq();
		}

		public void removeQueue(User user) {
			q.remove(user); //删除其中任意一个
			updateSeq();
		}
		
		

		/**
		 * 更新队列编号
		 */
		private void updateSeq() {
            int i= 1;
			for (User user : q) {
            	user.setSeq(i++);
			}	
		}
		
		
		public void printList() {
			for (User user : q) {
				System.out.println(user);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Myqueue myqueue = new Myqueue();
		myqueue.enqueue(new User(1, "wudi"));
		myqueue.enqueue(new User(2, "keke"));
		myqueue.enqueue(new User(3, "wuweizhi"));
		System.out.println("删除前：");
		myqueue.printList();
		//myqueue.removeQueue(new User(1, "wudi"));
		myqueue.deQueue();
		System.out.println("删除后：");
		myqueue.printList();
	}
	
	
	
	
}
