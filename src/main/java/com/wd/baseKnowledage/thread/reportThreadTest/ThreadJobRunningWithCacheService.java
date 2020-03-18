package com.wd.baseKnowledage.thread.reportThreadTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import com.wd.baseKnowledage.thread.reportThreadTest.callback.JobCallBack;
import com.wd.baseKnowledage.thread.reportThreadTest.exception.ThreadJobException;
import com.wd.baseKnowledage.thread.reportThreadTest.model.ThreadJob;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月7日 下午10:36:01
* 类说明    加入已经生成的缓存
*/
public  class ThreadJobRunningWithCacheService implements ThreadJobService  {
 
	private ThreadJobRunningService threadJobRunningService;
	
	
	private Map<String, Object> completeJobs = new ConcurrentHashMap<>(); //已经完成的
    
	
	/**
	 * 执行任务
	 * @param threadJob
	 * @return
	 * @throws ThreadJobException 
	 */
	public <T> T doJob(ThreadJob<T> threadJob) throws Exception {
		String key = threadJob.getKey();
		Object  result = completeJobs.get(key);
		if(result!=null){  
			return (T)result;
		}
		try {
			ThreadJob<T> newThreadJob = new ThreadJob<>();
			newThreadJob.setKey(key);
			newThreadJob.setWaitSeconds(threadJob.getWaitSeconds());
			newThreadJob.setCallable(threadJob.getCallable());
			newThreadJob.setJobCallBack(new JobCallBack<T>() {
				@Override
				public void callBack(T t) {
					completeJobs.put(key, t);
					threadJob.getJobCallBack().callBack(t);
				}
			});
			T doJob = threadJobRunningService.doJob(newThreadJob);
			completeJobs.put(key, doJob);
			return doJob;				
		}catch(TimeoutException e) {
			throw new TimeoutException(e.getMessage());
		}catch (ExecutionException e) {
			throw new ExecutionException(e.getMessage(),e);
		}	
	
	}
	
	
	
	public ThreadJobRunningService getThreadJobRunningService() {
		return threadJobRunningService;
	}

	public void setThreadJobRunningService(ThreadJobRunningService threadJobRunningService) {
		this.threadJobRunningService = threadJobRunningService;
	}

	
	
	
}
