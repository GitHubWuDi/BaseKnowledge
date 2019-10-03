package com.wd.baseKnowledage.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁打断
 * @author Administrator
 *
 */
public class ReentrantLockInterrupt {
     
	static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();
    
    public static void main(String[] args){
    	 Thread thread = new Thread(new ThreadDemo(lock1, lock2));//该线程先获取锁1,再获取锁2
         Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));//该线程先获取锁2,再获取锁1
         thread.start();
         thread1.start();
         thread1.interrupt();//是第一个线程中断
	}
    
    
    static class ThreadDemo implements Runnable{
    	 Lock firstLock;
         Lock secondLock;
    
     public ThreadDemo(Lock firstLock,Lock secoLock) {
    	 this.firstLock = firstLock;
    	 this.secondLock = secoLock;
     }
		@Override
		public void run() {
			 try {
				 firstLock.lockInterruptibly();
				 TimeUnit.MILLISECONDS.sleep(10);//更好的触发死锁
				 secondLock.lockInterruptibly();			 
			 }catch(InterruptedException e){
				 e.printStackTrace();
			 }finally{
				 firstLock.unlock();
				 secondLock.unlock();
				 System.out.println(Thread.currentThread().getName()+"正常结束!");
			 }
		}
    	
    }
	
	
}
