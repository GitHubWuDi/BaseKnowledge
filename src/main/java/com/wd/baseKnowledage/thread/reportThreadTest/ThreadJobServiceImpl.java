package com.wd.baseKnowledage.thread.reportThreadTest;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import com.wd.baseKnowledage.thread.reportThreadTest.callback.JobCallBack;
import com.wd.baseKnowledage.thread.reportThreadTest.exception.ThreadJobException;

/**
 * @author wudi E-mail:wudi891012@163.com
 * @version 创建时间：2020年3月6日 下午2:59:48 类说明 做一个任务，如果不超过3s直接返回;
 *          超过3s，则任务交给后台,完成以后返回回调;
 */
public class ThreadJobServiceImpl {
	private static Logger logger = Logger.getLogger(ThreadJobServiceImpl.class);
	private ExecutorService executor = Executors.newCachedThreadPool(); // 初始化线程池
    
	
	private Map<String, Object> waitCallBackMap = new ConcurrentHashMap<>();

	/**
	 * 获得对应的方法
	 * @param callable   入参线程
	 * @param jobCallBack 回调函数
	 * @return
	 * @throws Exception 
	 */
	public <T> T doJob(Integer seconds,Callable<T> callable, JobCallBack<T> jobCallBack) throws Exception{
		// 生成一个回调的futureTask值
		String jobKey = UUID.randomUUID().toString();
		FutureTask<T> futureTask = new FutureTask<>(new Callable<T>() {
			@Override
			public T call() throws Exception {
				T call = callable.call();
				tryCallBack(jobKey, call);
				return call;
			}
			/**
			 * 尝试函数回调
			 * 
			 * @param key
			 * @param result
			 */
			private void tryCallBack(String key, T result){
				synchronized (jobKey) {
					if (waitCallBackMap.containsKey(key) && waitCallBackMap.get(key) != null){
						jobCallBack.callBack(result);
						waitCallBackMap.remove(key);
					}else {
						waitCallBackMap.put(jobKey, result);
					}					
				}
			}
		});
		executor.execute(futureTask);
		try {
			if(seconds==null) {
				seconds = 3; //默认3s
			}
			System.out.println("等待时间："+seconds+"s");
			T t = futureTask.get(seconds, TimeUnit.SECONDS);
			synchronized (jobKey) {
				if(waitCallBackMap.containsKey(jobKey)){
					waitCallBackMap.remove(jobKey);
				}
			}
			return t;
		} catch (InterruptedException e) {
			logger.error("任务正在运行被打断", e);
			throw new InterruptedException("任务正在运行被打断");
		} catch (ExecutionException e) {
			logger.error("任务在尝试取得任务结果时出错", e);
			throw new ExecutionException("任务在尝试取得任务结果时出错", e);
		} catch (TimeoutException e) {
			//TODO 会存在，当这条线程刚判断超时，准备put一个waitCallback任务，线程池中就已经完成(一个线程3004ms)，并且tryCallback没有拿到。会导致逻辑失败且内存泄漏
			synchronized (jobKey) {
			if(waitCallBackMap.containsKey(jobKey)&&waitCallBackMap.get(jobKey)!=null) {
				return (T)waitCallBackMap.get(jobKey);
			  }else {				  
				  waitCallBackMap.put(jobKey, jobCallBack);
				 // throw new  ThreadJobException("超过限定的时间");
				  throw new  TimeoutException("超过限定的时间");
			  }
			}
		}
		
	}

	
	
}
