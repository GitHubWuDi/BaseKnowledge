package com.wd.baseKnowledage.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wudi E-mail:wudi891012@163.com
 * @version 创建时间：2019年9月25日 下午7:17:23 类说明 waitRunnable
 */
public class WaitRunable {
    
	public static void main(String[] args) {
		Object co = new Object();
		//5个线程调用wait对应进入到等待池当中
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new WaiteRunable(String.valueOf(i), co),"Thread "+i);
			thread.start();
		}
		//调用Notify或者是NotifyAll,回到锁池
		try {
		 TimeUnit.SECONDS.sleep(2);
		 System.out.println("---Main Thread notify-----");
		 synchronized (co) {
			 co.notifyAll();
		}
		 System.out.println("---Main Thread end-----");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static class WaiteRunable implements Runnable {
		private Object obj;
        private String name;
		public WaiteRunable(String name,Object obj){
			this.obj = obj;
			this.name = name;
		}
		
		
		@Override
		public void run() {
			try {
				System.out.println("Thread "+name+" is waiting"); //线程开始等待
				synchronized (obj) {
					obj.wait();
				}
				System.out.println("Thread "+name+" has been notified"); //线程已经被唤醒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
