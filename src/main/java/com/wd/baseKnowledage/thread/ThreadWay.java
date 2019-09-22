package com.wd.baseKnowledage.thread;

/**
 * 通过继承Tread完成线程的创建工作
 * @author Administrator
 *
 */
public class ThreadWay extends Thread {

	//声明默认构造函数
	public ThreadWay() {}
	
	
	//重写Thread的run方法
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			 try {
	                Thread.sleep(100) ;
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            } 
	       System.out.println(i); 
		}
	}
	
	
	public static void main(String[] args) {
		ThreadWay threadWay = new ThreadWay();  //实例化ThreadWay线程
		threadWay.currentThread().setName("ThreadWay");
		threadWay.start();
		System.out.println("name:"+threadWay.currentThread().getName());
	}
	
	
}
