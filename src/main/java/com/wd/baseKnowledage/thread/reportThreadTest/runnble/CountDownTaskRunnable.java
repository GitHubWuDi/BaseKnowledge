package com.wd.baseKnowledage.thread.reportThreadTest.runnble;

import java.util.concurrent.CountDownLatch;

import com.wd.baseKnowledage.thread.reportThreadTest.DownLoadReportImpl;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月5日 下午7:37:13
* 类说明     没有返回值的runnable
*/
public class CountDownTaskRunnable implements Runnable {

	
	private String name;
	private Integer seconds;
	private CountDownLatch countDownLatch;
	private Integer count;
	
	private volatile static DownLoadReportImpl downLoadReportInstance;
	
	public  CountDownTaskRunnable(String name,Integer seconds,CountDownLatch countDownLatch){
		this.name = name;
		this.seconds = seconds;
		this.countDownLatch = countDownLatch;
	}
	
	public  CountDownTaskRunnable(String name,Integer seconds,CountDownLatch countDownLatch,Integer count){
		this.name = name;
		this.seconds = seconds;
		this.countDownLatch = countDownLatch;
		this.count = count;
	}
	
	/**
	 * 双重检查锁
	 * @return
	 */
	public static DownLoadReportImpl getDownLoadReportInstance(){
		if(downLoadReportInstance==null) {
			synchronized (CountDownTaskRunnable.class) {
				if(downLoadReportInstance==null) {
					downLoadReportInstance = new DownLoadReportImpl();
				}
			}
		}
		return downLoadReportInstance;
	}
	
	
	@Override
	public void run() {
		DownLoadReportImpl downLoadReportImpl = getDownLoadReportInstance();
		boolean result = downLoadReportImpl.downLoadReport(name,seconds,count);
		System.out.println(name+seconds+"s "+"次数"+count+":"+result);
		countDownLatch.countDown();  //计数减1
	}

}
