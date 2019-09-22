package com.wd.baseKnowledage.thread.interrupt;

import org.apache.log4j.Logger;

/**
 * @author wudi
 * @version 创建时间：2018年10月21日 上午11:00:18
 * @ClassName 类名称
 * @Description 中断测试类
 */
public class InterruptTest {

	private static Logger logger = Logger.getLogger(InterruptTest.class);

	public static class InterruptRunnable implements Runnable {

		@Override
		public void run() {
			while ((!Thread.currentThread().isInterrupted()) && true) {
				try {
					logger.info("线程ID:" + Thread.currentThread().getId());
					Thread.sleep(40);
				} catch (InterruptedException e) {
					logger.info(Thread.currentThread().getName() + "睡眠被打断!", e);
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	/**
	 * 进行选择退出中断线程
	 * @author Administrator
	 *
	 */
	public static class selectInterruptRunnable implements Runnable {
		@Override
		public void run() {
			while (Thread.currentThread().isInterrupted()) {
				System.out.println("exit MyThread");
				break;
			}

		}

	}

	public static void main(String[] args) {
		Thread thread = new Thread(new selectInterruptRunnable());
		thread.start();
		thread.interrupt();
		System.out.println(thread.isInterrupted());
//		try {
//			thread.interrupt();
//			Thread.currentThread().interrupt();
//			Thread.sleep(2000);
//			System.out.println(thread.isInterrupted());
//		} catch (InterruptedException e) {
//			logger.info("睡眠被打断!", e);
//		}
	}

}
