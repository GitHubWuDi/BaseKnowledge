package com.wd.baseKnowledage.thread.reportThreadTest.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import com.wd.baseKnowledage.thread.reportThreadTest.DownLoadReportImpl;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月5日 下午5:36:44
* 类说明    使用CountDown的task
*/
public class CountDownLatchTask implements Callable<Boolean> {

	private String name;
	private Integer seconds;
	private CountDownLatch countDownLatch;
	private Integer count;
	
	private volatile static DownLoadReportImpl downLoadReportInstance;
	
	public  CountDownLatchTask(String name,Integer seconds,CountDownLatch countDownLatch,Integer count){
		this.name = name;
		this.seconds = seconds;
		this.countDownLatch = countDownLatch;
		this.count  = count;
	}
	
	/**
	 * 双重检查锁
	 * @return
	 */
	public static DownLoadReportImpl getDownLoadReportInstance(){
		if(downLoadReportInstance==null) {
			synchronized (CountDownLatchTask.class) {
				if(downLoadReportInstance==null) {
					downLoadReportInstance = new DownLoadReportImpl();
				}
			}
		}
		return downLoadReportInstance;
	}
	
	
	
	@Override
	public Boolean call() throws Exception {
		DownLoadReportImpl downLoadReportImpl = getDownLoadReportInstance();
		boolean result = downLoadReportImpl.downLoadReport(name,seconds,count);
		countDownLatch.countDown();  //计数减1
		System.out.println(name+seconds+"s "+"次数："+count+"生成结果："+result);
		return result;
	
	}

}
