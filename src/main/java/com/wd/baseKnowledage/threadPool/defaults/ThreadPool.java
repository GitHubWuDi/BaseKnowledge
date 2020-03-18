package com.wd.baseKnowledage.threadPool.defaults;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年2月3日 下午5:24:06
* 类说明
*/
public interface ThreadPool<Job extends Runnable> {
	 // 执行一个Job，这个Job需要实现Runnable
	void execute(Job job);
    // 关闭线程池
    void shutdown();
    // 增加工作者线程
    void addWorkers(int num);
    // 减少工作者线程
    void removeWorker(int num);
    // 得到正在等待执行的任务数量
    int getJobSize();
}
