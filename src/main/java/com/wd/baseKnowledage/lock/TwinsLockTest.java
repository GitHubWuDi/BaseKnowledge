package com.wd.baseKnowledage.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author wudi E-mail:wudi891012@163.com
 * @version 创建时间：2020年2月5日 下午6:13:32 类说明
 */
public class TwinsLockTest {

	 static final Lock lock = new TwinsLock();

	public static  class Worker extends Thread {
		public void run() {
                    while (true) {
                            lock.lock();
                            try {
                                   try {
									Thread.sleep(1000);
									System.out.println(Thread.currentThread().getName());
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
                            } finally {
                                    lock.unlock();
                            }
                    }
		}
	}
	
	
	public static void main(String[] args) {
		// 启动10个线程
        for (int i = 0; i < 10; i++) {
                Worker worker = new Worker();
                worker.setDaemon(true);
                worker.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
        	     try {
					Thread.sleep(1000);
					System.out.println();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }

	}
}
