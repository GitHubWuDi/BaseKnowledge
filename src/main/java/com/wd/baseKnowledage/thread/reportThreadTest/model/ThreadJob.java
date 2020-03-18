package com.wd.baseKnowledage.thread.reportThreadTest.model;

import java.util.concurrent.Callable;

import com.wd.baseKnowledage.thread.reportThreadTest.callback.JobCallBack;

import lombok.Data;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月6日 下午7:20:41
* 类说明    线程工作实体
*/
@Data
public class ThreadJob<T> {
	
	private Integer waitSeconds;
	private String key; //线程工作的JOB
	private Callable<T> callable; //返回一个callable
	private JobCallBack<T> jobCallBack; //回调函数
	
}
