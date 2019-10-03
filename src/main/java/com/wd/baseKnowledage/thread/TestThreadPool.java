package com.wd.baseKnowledage.thread;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2019年9月25日 下午7:56:15
* 类说明
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

	static ExecutorService fixExecutors = Executors.newFixedThreadPool(3); // 长线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量，这时线程数量不再变化，当线程发生错误结束时，线程池会补充一个新的线程
	static ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(); // 可缓存的线程池，如果线程池的容量超过了任务数，自动回收空闲线程，任务增加时可以自动添加新线程，线程池的容量不限制
	static ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3); // 定长周期线程池
	static ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(); // 单线程的线程池，线程异常结束，会创建一个新的线程，能确保任务按提交顺序执行

	public static void main(String[] args) {
		fixExecutorsFunction();
	}

	public static void fixExecutorsFunction() {
		for (int i = 0; i < 6; i++) {
			final int index = i;
			fixExecutors.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " index:" + index);
				}
			});
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("4秒后...");
		
		fixExecutors.shutdown();
	}


}
