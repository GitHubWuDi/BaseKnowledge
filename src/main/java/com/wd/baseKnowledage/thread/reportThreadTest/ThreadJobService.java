package com.wd.baseKnowledage.thread.reportThreadTest;

import com.wd.baseKnowledage.thread.reportThreadTest.model.ThreadJob;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月11日 下午10:44:23
* 类说明
*/
public interface ThreadJobService {

	public <T> T doJob(ThreadJob<T> threadJob) throws Exception;
}
