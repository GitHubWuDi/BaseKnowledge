package com.wd.baseKnowledage.thread.reportThreadTest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月6日 下午7:24:32
* 类说明   线程含有结果的实体
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class ThreadJobWithResult<T> extends ThreadJob<T> {

	private volatile boolean finish;
	private volatile T result;
	
	public ThreadJobWithResult(ThreadJob<T> threadJob) {
		this.setFinish(false);
		this.setKey(threadJob.getKey());
		this.setCallable(threadJob.getCallable());
		this.setJobCallBack(threadJob.getJobCallBack());
		this.setWaitSeconds(threadJob.getWaitSeconds());
	}
	
	
	
}
