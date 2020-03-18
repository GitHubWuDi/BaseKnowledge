package com.wd.baseKnowledage.thread.reportThreadTest.future;

import java.util.concurrent.Callable;

import com.wd.baseKnowledage.thread.reportThreadTest.DownLoadReportImpl;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月5日 下午2:41:52
* 类说明   任务类
*/
public class Task implements Callable<Boolean> {

	private String name;
	private Integer sceonds;
	private Integer count;
	
	public Task(String name,Integer sceonds,Integer count) {
		this.name = name;
		this.sceonds = sceonds;
		this.count = count;
	}
	
	
	@Override
	public Boolean call(){
		DownLoadReportImpl downLoadReportImpl = new DownLoadReportImpl();
		boolean result = downLoadReportImpl.downLoadReport(name,sceonds,count);
		return result;
	}

}
