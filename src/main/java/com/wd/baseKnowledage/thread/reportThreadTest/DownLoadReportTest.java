package com.wd.baseKnowledage.thread.reportThreadTest;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月5日 上午10:17:34
* 类说明
*/

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;

import com.wd.baseKnowledage.thread.reportThreadTest.callback.JobCallBack;
import com.wd.baseKnowledage.thread.reportThreadTest.callback.JobCallBackImpl;
import com.wd.baseKnowledage.thread.reportThreadTest.future.CountDownLatchTask;
import com.wd.baseKnowledage.thread.reportThreadTest.future.Task;
import com.wd.baseKnowledage.thread.reportThreadTest.future.TaskTest;
import com.wd.baseKnowledage.thread.reportThreadTest.runnble.CountDownTaskRunnable;
import com.wd.baseKnowledage.util.DateUtil;

public class DownLoadReportTest {
	private ExecutorService executor;
	
	private Object obj = new Object();

	@Before
	public void initThreadPool() { // 初始化线程池
		executor = Executors.newCachedThreadPool();
	}

	/**
	 * 当生成报表只需要2s，直接返回报表的文件信息
	 * 
	 */
	@Test
	public void testDownLoadReportBy2Secs() {
		String name = "测试报表";
		Task task = new Task(name, 2, 1);
		Future<Boolean> future = executor.submit(task);
		try {
			Boolean result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void testDownLoadReport() {
		 Map<String,Object> maps = new HashMap<>(); 
		TaskTest taskTest = new TaskTest();
		Future<Boolean> future = executor.submit(taskTest);
		try {
			future.get(3L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("线程已经超时");
			System.out.println(maps.put("ssss", "ddddd")+"放入一个map的时间："+DateUtil.format(new Date()));
			
		}
		
		
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 当生存报表需要4s，3s后返回提示信息。并在4s的时候执行消息推送
	 * 
	 */
	@Test
	public void testDownLoadReportBy4Secs() {
		String name = "测试报表";
		Task task = new Task(name, 4, 1);
		//long beginTime = System.currentTimeMillis();
		Future<Boolean> future = executor.submit(task);
		Boolean result = false;
		try {
			result = future.get(3L, TimeUnit.SECONDS);
			if (result) { // 是否在3s内完成
				System.out.println("触发下载,直接返回");
			}
		} catch (InterruptedException e) {
			System.out.println("任务正在运行被打断");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("任务在尝试取得任务结果时出错");
			e.printStackTrace();
		} catch (TimeoutException e) {
			future.cancel(true);
			System.out.println("任务时间规定时间3s，已超时！,返回提示信息");
			return;
		} 
	}

	/**
	 * 当生存报表需要4s，第一次发送请求后，第5s发送请求能直接返回文件信息
	 */
	@Test
	public void testDownLoadReportBy5Sec() {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		String name = "测试报表";
		CountDownLatchTask task = new CountDownLatchTask(name, 4, countDownLatch, 1);
		Future<Boolean> future = executor.submit(task);
		try {

			boolean result = future.get();
			Thread.sleep(1000); // 间隔1s
			CountDownLatchTask task2 = new CountDownLatchTask(name, 4, countDownLatch, 2);
			Future<Boolean> future2 = executor.submit(task2);
			Boolean result2 = future2.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 当生存报表需要4s，第一次请求发送后，在3s的时候发送第二次请求，能再第4s返回文件信息
	 */
	@Test
	public void testDownLoadReport1() {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		String name = "测试报表";
		CountDownLatchTask task = new CountDownLatchTask(name, 4, countDownLatch, 1); // 第一次请求
		Future<Boolean> future1 = executor.submit(task);
		try {
			// Thread.sleep(3000);
			// System.out.println("间隔三秒钟");
			Boolean result1 = future1.get(3L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			try {
				future1.cancel(true);
				CountDownLatchTask task1 = new CountDownLatchTask(name, 4, countDownLatch, 2); // 第二次请求
				Future<Boolean> future2 = executor.submit(task1);
				Boolean result2 = future2.get();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
		}

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当报表生成需要12s，第一次请求发送后，每秒发送一次请求，发送10次。第10次应该直接返回文件信息，前面9次返回推送消息。并只执行一次消息推送。（callable带返回值，目前失败）
	 */
	@Test
	public void testDownLoadReport2() {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		String name = "测试报表";
			CountDownLatchTask task3 = new CountDownLatchTask(name, 3, countDownLatch, 1);
			Future<Boolean> future1 = executor.submit(task3);
		try {
			Thread.sleep(1 * 1000); // TODO 1s以后请求
			Boolean boolean1 = future1.get(1L, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			future1.cancel(true);
			try {
				for (int i = 2; i < 6; i++) {
					Thread.sleep(1*1000);
					CountDownLatchTask countDownLatchTask1 = new CountDownLatchTask(name,3,countDownLatch,i);
					Future<Boolean> future2 = executor.submit(countDownLatchTask1);
					Boolean boolean2 = future2.get();  //TODO future2 get请求这个地方会阻塞
				}
			}catch (InterruptedException t) {
				t.printStackTrace();
			}catch (ExecutionException t) {
				t.printStackTrace();
			}
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//
	// 12s的生成的

	/**
	 * 当报表生成需要6s，第一次请求发送后，每秒发送一次请求，发送10次。第10次应该直接返回文件信息，前面9次返回推送消息。并只执行一次消息推送。（不带返回值）
	 * 在线程池放入过程当中虽然代码有先后顺序，但是两个线程可能同时启动
	 */
	@Test
	public void testDownLoadReport3() {
		CountDownLatch countDownLatch = new CountDownLatch(8);
		String name = "测试报表";
		try {
			CountDownTaskRunnable task = new CountDownTaskRunnable(name, 6, countDownLatch, 1);
			executor.execute(task);
			// TODO 这个地方先睡1s，模拟1s之后点击
			Thread.sleep(1000);
			for (int i = 0; i < 7; i++) {
				Thread.sleep(1000);
				CountDownTaskRunnable countDownLatchTask = new CountDownTaskRunnable(name, 6, countDownLatch, i);
				executor.execute(countDownLatchTask);
			}
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 采用封装以后的输出结果
	 * 当生存报表需要4s，3s后返回提示信息。并在4s的时候执行消息推送
	 */
	@Test
	public void testDownLoadReport4(){
		ThreadJobServiceImpl threadJobServiceImpl = new ThreadJobServiceImpl();
		JobCallBack<Boolean> jobCallBack =new JobCallBackImpl();
		String name = "测试代码";
		Task task = new Task(name,5,1);
	    try {
			Boolean doJob = threadJobServiceImpl.doJob(5,task, jobCallBack);
			System.out.println(name+"直接返回job结果："+doJob);
		} catch (Exception e) {
			System.out.println("异常返回:3s超时，请等待");
			System.out.println(e.getMessage());
		}

	    try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}
