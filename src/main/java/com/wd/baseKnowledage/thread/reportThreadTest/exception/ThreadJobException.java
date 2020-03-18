package com.wd.baseKnowledage.thread.reportThreadTest.exception;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月6日 下午6:55:48
* 类说明     线程Job异常
*/
public class ThreadJobException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ThreadJobException(String message) {
		super(message);
	}
	
	public ThreadJobException(String message,Throwable t){
		super(message, t);
	}
}
