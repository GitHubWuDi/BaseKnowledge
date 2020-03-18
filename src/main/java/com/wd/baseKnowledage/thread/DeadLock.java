package com.wd.baseKnowledage.thread;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2019年9月30日 上午9:59:51
* 类说明
*/
public class DeadLock {

	private final static Object obj1 = new Object();
	private final static Object obj2 = new Object();
	
	
	public static void main(String[] args) {
		deadLockTest();
	}
	
	
	public static void deadLockTest() {
		
		Thread thread1 = new Thread() {
			@Override
			public void run(){
			    synchronized (obj1) {
					System.out.println("Thread1:locked obj1");
					try {
						Thread.sleep(3000);
						System.out.println("Thread1: obj1 wait obj2");
					} catch (InterruptedException e) {
						 Thread.currentThread().interrupt();
					}
					//尝试占用resource2
					synchronized (obj2) {
						System.out.println("Thread1:locked obj2");
					}
				}
			    
			}
		};
		
		Thread thread2 = new Thread() {
			@Override
			public void run(){
				try {
					Thread.sleep(50);
					synchronized (obj2) {
						System.out.println("Thread2:locked obj2");
						Thread.sleep(3000);
						System.out.println("Thread2: obj2 wait obj1");
						//尝试占用resource2
						synchronized (obj1) {
							System.out.println("Thread2:locked obj1");
						}
						
					}
					
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			    
			   
			}
		};
		
		thread1.start();
		thread2.start();
	}
	
	
	
	
	
	
	
}
