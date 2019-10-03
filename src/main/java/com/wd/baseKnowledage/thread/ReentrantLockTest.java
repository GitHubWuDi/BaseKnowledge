package com.wd.baseKnowledage.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	static ReentrantLock lock = new ReentrantLock(true);
	
	public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
			new Thread(new RunnableDemo(i)).start();
		}

    }
	
	static class RunnableDemo implements Runnable{
		
		Integer id;
		
		public RunnableDemo(Integer id){
			this.id = id;
		}
		
		@Override
		public void run() {
			 try {
	                TimeUnit.MILLISECONDS.sleep(10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            for(int i=0;i<2;i++){
	                lock.lock();
	                System.out.println("获得锁的线程："+id);
	                lock.unlock();
	            }	
		}
		
	}
	
	
	
}
