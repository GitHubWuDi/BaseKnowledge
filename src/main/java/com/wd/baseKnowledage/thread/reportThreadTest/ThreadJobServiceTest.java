package com.wd.baseKnowledage.thread.reportThreadTest;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;

import com.wd.baseKnowledage.thread.reportThreadTest.callback.JobCallBack;
import com.wd.baseKnowledage.thread.reportThreadTest.model.ThreadJob;
import com.wd.baseKnowledage.util.DateUtil;

/**
 * @author wudi E-mail:wudi891012@163.com
 * @version 创建时间：2020年3月7日 下午3:27:02 类说明 线程测试机制
 */

public class ThreadJobServiceTest {

	ThreadJobRunningWithCacheService threadJobRunningCacheService = new ThreadJobRunningWithCacheService();
	ThreadJobRunningService threadJobRunningService = new ThreadJobRunningService();
	ThreadJobServiceImpl threadJobService = new ThreadJobServiceImpl();
	ThreadJob<String> threadJob = new ThreadJob<>();

	@Before
	public void createThreadJobRunning() {

		threadJobRunningService.setThreadJobService(threadJobService);
		threadJobRunningCacheService.setThreadJobRunningService(threadJobRunningService);
		threadJob.setKey("a");

		threadJob.setJobCallBack(new JobCallBack<String>(){
			@Override
			public void callBack(String t) {
				System.out.println(Thread.currentThread().getName() + "调用回调函数，执行结果：" + t+",回调时间："+DateUtil.format(new Date()));
			}
		});
		// TODO 默认测试是4s钟
		threadJob.setCallable(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(4 * 1000);
				return "test"; // TODO 直接返回的对象
			}
		});
	}

	/**
	 * 当生成报表只需要2s，直接返回报表的文件信息 预期结果：线程运行2s，直接返回test
	 * @throws Exception 
	 */
	@Test
	public void testDownLoadReport1() throws Exception{
		try {
			threadJob.setCallable(new Callable<String>() {
				@Override
				public String call() throws Exception {
				try {
					Thread.sleep(4 * 1000);
					Integer a = 1/0;
					return String.valueOf(a);					
				}catch(Exception e) {
					return "error";
				}
					//
				//return "test";
				}
			});
			String doJob = threadJobRunningService.doJob(threadJob);
			System.out.println("直接返回结果：" + doJob);
		}catch (ExecutionException e) {
			System.out.println("执行异常结果：" + e.getMessage());
		}catch (TimeoutException e) {
			System.out.println("返回异常，异常结果：" + e.getMessage());
		}

		// 让线程充分执行完成
		try {
			Thread.sleep(6 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 当生存报表需要4s，3s后返回提示信息。并在4s的时候执行消息推送 预期结果：线程运行四秒 .3s提示结果返回异常,线程正在运行,异常结果：
	 * 4s调用回调函数，执行结果：
	 */
	@Test
	public void testDownLoadReport2() throws Exception {
		try {
			threadJob.setCallable(new Callable<String>() {
				@Override
				public String call() throws Exception {
					Thread.sleep(4 * 1000);
					return "test"; // TODO 直接返回的对象
				}
			});
			String doJob;
				doJob = threadJobRunningService.doJob(threadJob);
			System.out.println("直接返回结果：" + doJob);
		} catch (TimeoutException e) {
			System.out.println("返回异常,线程正在运行,异常结果：" + e.getMessage());
		}catch (ExecutionException e) {
			  e.printStackTrace();
		}

		// 让线程充分执行完成
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当生存报表需要4s，第一次发送请求后，第5s发送请求能直接返回文件信息。 预期结果：第一个线程执行4s完成以后，第5s发出第二个请求，直接返回结果
	 */
	@Test
	public void testDownLoadReport3() throws Exception {

		try {
			String doJob = threadJobRunningCacheService.doJob(threadJob);
			System.out.println("第一次直接返回结果：" + doJob);
		} catch (TimeoutException e) {
			System.out.println("第一次返回异常,线程正在运行,异常结果：" + e.getMessage());
		}catch (ExecutionException e) {
			  e.printStackTrace();
		}
		// TODO 过1s
		try {
			System.out.println("过2s执行第二次请求");
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// TODO 再次启动一个线程
		try {
			String doJob = threadJobRunningCacheService.doJob(threadJob);
			System.out.println("第二次直接返回结果：" + doJob);
		} catch (TimeoutException e) {
			System.out.println("第二次返回异常,线程正在运行,异常结果：" + e.getMessage());
		}catch (ExecutionException e) {
			  e.printStackTrace();
		}

		// TODO 确保线程执行完成
		try {
			System.out.println();
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当生存报表需要4s，第一次请求发送后，在3s的时候发送第二次请求，能再第4s返回文件信息
	 * 第一次返回异常,线程正在运行,异常结果：超时未返回；调用回调函数，执行结果：test；第二次直接返回结果：test
	 * 
	 * 两个不同的请求，同时触发，一个要求等待时间3s ，一个要求等待时间2s，结果返回第一个线程
	 * 第一次发送时间：2020-03-12 14:52:36
	        第二次发送时间：2020-03-12 14:52:36
	        等待时间：3s
	        等待时间：2s
	       异常返回时间：2020-03-12 14:52:39，第二次返回异常,线程正在运行,异常结果：超时未返回
	      异常返回时间：2020-03-12 14:52:40，第一次返回异常,线程正在运行,异常结果：超时未返回
	  pool-1-thread-2调用回调函数，执行结果：test,回调时间：2020-03-12 14:52:41
	  pool-1-thread-1调用回调函数，执行结果：test,回调时间：2020-03-12 14:52:41
	 * 
	 */
	@Test
	public void testDownLoadReport4()  throws Exception {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadJob.setKey("a");
					threadJob.setWaitSeconds(3);
					String doJob = threadJobRunningCacheService.doJob(threadJob);
					System.out.println("第一次直接返回结果：" + doJob);
				} catch (TimeoutException e) {
					System.out.println("异常返回时间："+DateUtil.format(new Date())+"，第一次返回异常,线程正在运行,异常结果：" + e.getMessage());
				}catch (ExecutionException e) {
					  e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "thread1");
		System.out.println("第一次发送时间："+DateUtil.format(new Date()));
		thread1.start();
		/*try {
			System.out.println("在第5s的时候，发出第二次请求");
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}*/

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadJob.setKey("b");
					threadJob.setWaitSeconds(2);
					String doJob = threadJobRunningCacheService.doJob(threadJob);
					System.out.println("第二次直接返回结果：" + doJob);
				} catch (TimeoutException e) {
					System.out.println("异常返回时间："+DateUtil.format(new Date())+"，第二次返回异常,线程正在运行,异常结果：" + e.getMessage());
				}catch (ExecutionException e) {
					  e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"thread2");
		System.out.println("第二次发送时间："+DateUtil.format(new Date()));
		thread2.start();

		// TODO 确保线程执行完成
		try {
			Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 当生存报表需要8s，第一次请求发送后，在3s的时候发送第二次请求： 预期效果：第3s第一次请求返回异常,线程正在运行,异常结果：超时未返回；
	 * 第6s第二次请求返回异常,线程正在运行,异常结果：超时未返回； 第11s的第一次请求调用回调函数，执行结果：test
	 * 
	 */
	@Test
	public void testDownLoadReport5() {

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadJob.setCallable(new Callable<String>() {
						@Override
						public String call() throws Exception {
							Thread.sleep(8 * 1000);
							return "test"; // TODO 直接返回的对象
						}
					});
					String doJob = threadJobRunningCacheService.doJob(threadJob);
					System.out.println("第一次请求直接返回结果：" + doJob);
				} catch (TimeoutException e) {
					System.out.println("第一次请求返回异常,线程正在运行,异常结果：" + e.getMessage());
				}catch (ExecutionException e) {
					  e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "thread1");

		thread1.start();

		// TODO 确保线程执行完成
		try {
			System.out.println("在第3s执行第二次请求");
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadJob.setCallable(new Callable<String>() {
						@Override
						public String call() throws Exception {
							Thread.sleep(8 * 1000);
							return "test"; // TODO 直接返回的对象
						}
					});
					String doJob = threadJobRunningCacheService.doJob(threadJob);
					System.out.println("第二次请求直接返回结果：" + doJob);
				} catch (TimeoutException e) {
					System.out.println("第二次请求返回异常,线程正在运行,异常结果：" + e.getMessage());
				}catch (ExecutionException e) {
					  e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "thread2");

		thread2.start();

		// TODO 确保线程执行完成
		try {
			System.out.println();
			Thread.sleep(15 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 两个8s的线程同时执行的情况
	 */
	@Test
	public void testDownLoadReport6(){
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadJob.setKey("a");
					threadJob.setCallable(new Callable<String>() {
						@Override
						public String call() throws Exception {
							Thread.sleep(2 * 1000);
							return "test"; // TODO 直接返回的对象
						}
					});
					String doJob = threadJobRunningCacheService.doJob(threadJob);
					System.out.println("第一次请求直接返回结果：" + doJob);
				} catch (TimeoutException e) {
					System.out.println("第一次请求返回异常,线程正在运行,异常结果：" + e.getMessage());
					System.out.println(Thread.currentThread().getName()+"测试结束时间：" + DateUtil.format(new Date()));
				}catch (ExecutionException e) {
					  e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "thread1");


		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadJob.setKey("b");
					threadJob.setCallable(new Callable<String>() {
						@Override
						public String call() throws Exception {
							Thread.sleep(2 * 1000);
							return "test"; // TODO 直接返回的对象
						}
					});
					String doJob = threadJobRunningCacheService.doJob(threadJob);
					System.out.println("第二次请求直接返回结果：" + doJob);
				} catch (TimeoutException e) {
					System.out.println("第二次请求返回异常,线程正在运行,异常结果：" + e.getMessage());
					System.out.println(Thread.currentThread().getName()+"测试结束时间：" + DateUtil.format(new Date()));
				}catch (ExecutionException e) {
					  e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "thread2");
		thread1.start();
		System.out.println("第一个线程测试开始时间：" + DateUtil.format(new Date()));
		thread2.start();
		System.out.println("第二个线程测试开始时间：" + DateUtil.format(new Date()));

		// TODO 确保线程执行完成
		try {
			System.out.println();
			Thread.sleep(15 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 第10个线程执行4s的线程同时执行
	 * 
	 */
	@Test
	public void testDownLoadReport7(){
		for (int i = 1; i <= 10; i++) {
			Thread thread = new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						threadJob.setCallable(new Callable<String>() {
							@Override
							public String call() throws Exception {
								Thread.sleep(4 * 1000);
								return "test"; // TODO 直接返回的对象
							}
						});
						String doJob = threadJobRunningCacheService.doJob(threadJob);
						System.out.println(Thread.currentThread().getName()+"请求直接返回结果：" + doJob);
					} catch (TimeoutException e) {
						System.out.println(Thread.currentThread().getName()+"请求返回异常,线程正在运行,异常结果：" + e.getMessage());
						//System.out.println(Thread.currentThread().getName()+"测试结束时间：" + DateUtil.format(new Date()));
					}catch (ExecutionException e) {
						  e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, "thread"+i);
			System.out.println("thread"+i+"线程启动时间："+DateUtil.format(new Date()));
			thread.start();
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// TODO 确保线程执行完成
				try {
					System.out.println();
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}
	
	

	
	

}
