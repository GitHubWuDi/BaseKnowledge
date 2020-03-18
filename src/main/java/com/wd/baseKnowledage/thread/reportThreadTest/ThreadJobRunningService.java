package com.wd.baseKnowledage.thread.reportThreadTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import com.wd.baseKnowledage.thread.reportThreadTest.callback.JobCallBack;
import com.wd.baseKnowledage.thread.reportThreadTest.exception.ThreadJobException;
import com.wd.baseKnowledage.thread.reportThreadTest.model.ThreadJob;
import com.wd.baseKnowledage.thread.reportThreadTest.model.ThreadJobWithResult;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月6日 下午7:20:00
* 类说明    线程JOB在运行过程当中的封装
*/
public class ThreadJobRunningService implements ThreadJobService {

	private ThreadJobServiceImpl threadJobService;
	private Map<String,ThreadJobWithResult> runningJob = new ConcurrentHashMap<>();  //正在运行的
	
	
	public <T> T doJob(ThreadJob<T> threadJob) throws Exception {
		
		String key = threadJob.getKey();
		ThreadJobWithResult threadJobWithResult = null;
		

		synchronized (runningJob) {
			threadJobWithResult = runningJob.get(key);
			if(threadJobWithResult==null){
				runningJob.put(key, new ThreadJobWithResult<>(threadJob));
			}			
		}
		if(threadJobWithResult!=null){
			try {
				return existWaitJob(threadJobWithResult);
			} catch (TimeoutException e) {
				throw new TimeoutException("超时未返回");
			}				
		}else {
			try {
				Integer waitSeconds = threadJob.getWaitSeconds();
				T doJob = threadJobService.doJob(waitSeconds,threadJob.getCallable(), new JobCallBack<T>(){
					@Override
					public void callBack(T result){
						successCompleteJob(threadJob, result);
						threadJob.getJobCallBack().callBack(result); //执行回调
					}				
				});
				successCompleteJob(threadJob, doJob);
				return doJob;
			} catch (TimeoutException e) {
				throw new TimeoutException(e.getMessage());
			}catch (ExecutionException e) {
				throw new ExecutionException(e.getMessage(),e);
			}				
		}
	}


	/**
	 * 是否在runningJobs当中存在等待任务
	 * @param threadJobWithResult
	 * @return
	 * @throws ThreadJobException
	 */
	protected <T> T existWaitJob(ThreadJobWithResult threadJobWithResult) throws TimeoutException {
		synchronized(threadJobWithResult){   
			if(threadJobWithResult.isFinish()) {//如果已经完成,直接返回结果
				Object result = threadJobWithResult.getResult();
				return (T)result;
			}else { //如果没有完成，信号量等待3s钟，完成则直接放回，否则采取回调的方式进行
				try {
					threadJobWithResult.wait(threadJobWithResult.getWaitSeconds());
					if(threadJobWithResult.isFinish()){
						Object result = threadJobWithResult.getResult();
						return (T)result;						
					}else {
						throw new TimeoutException("超时未返回");
					}
				} catch (InterruptedException e) {
					throw new TimeoutException("超时未返回");
				}
			}
		}
	}

	protected <T> void successCompleteJob(ThreadJob<T> threadJob, T result) {
		String key = threadJob.getKey();
		if(runningJob.containsKey(key) && runningJob.get(key)!=null){
			ThreadJobWithResult threadJobWithResult = runningJob.get(threadJob.getKey());
			synchronized(threadJobWithResult){
				threadJobWithResult.setFinish(true);
				threadJobWithResult.setResult(result);
				runningJob.remove(key);
				threadJobWithResult.notifyAll();				
			}
		}
	}
	
	public ThreadJobServiceImpl getThreadJobService() {
		return threadJobService;
	}

	public void setThreadJobService(ThreadJobServiceImpl threadJobService) {
		this.threadJobService = threadJobService;
	}
	

	
	
}
