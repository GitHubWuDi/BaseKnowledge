package com.wd.baseKnowledage.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月18日 下午8:17:56
* 类说明    阻塞queue
*/
public class BlockQueue<T> {

	public LinkedBlockingQueue<T> linkBlockingQueue = new LinkedBlockingQueue<>();
	
	/**
	 * 无参构造函数
	 */
	public BlockQueue() {
		
	}
	
	public BlockQueue(Integer queueSize) {
		linkBlockingQueue  = new LinkedBlockingQueue<>(queueSize);
	}
	
	
	/**
	 * 插入数据
	 * @param t
	 * @throws BlockQueueException 
	 */
    public void insert(T t) throws BlockQueueException{
    	try {
			linkBlockingQueue.put(t);
		} catch (InterruptedException e) {
			throw new BlockQueueException("插入队列失败");
		}
    }
    
    
    public T take() throws BlockQueueException {
    	try {
			T t = linkBlockingQueue.take();
			return t;
		} catch (InterruptedException e) {
			throw new BlockQueueException("消费队列失败");
		}
		
    }
    
    
    
	
	
	
}
