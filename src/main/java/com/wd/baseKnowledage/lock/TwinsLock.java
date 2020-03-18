package com.wd.baseKnowledage.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年2月5日 下午5:38:10
* 类说明   同时只有两个线程能够共享式访问，多于两个线程的则无法访问
*/
public class TwinsLock implements Lock {

	private final Sync    sync    = new Sync(2);
	private static class Sync extends AbstractQueuedSynchronizer{
		Sync(int count){
			if(count<=0) {
				throw new IllegalArgumentException("count must large than zero");
			}
			setState(count);
		}
		
		/**
		 * 获得对应的锁
		 */
		public int tryAcquireShared(int reduceCount) {
			for (;;) {
				int current = getState();
				int newCount = current-reduceCount;
				if(newCount<0||compareAndSetState(current, newCount)){
					return newCount;
				}
			}
		} 
		
		/**
		 * 尝试释放锁
		 */
		public boolean tryReleaseShared(int returnCount){
			for (;;) {
				int current = getState();
				int newCount = current+returnCount;
				if(compareAndSetState(current, newCount)) {
					return true;
				}
			}
		}
		
	}
	public void lock() {
		sync.tryAcquireShared(1);
	}
	
	public void unlock() {
		sync.tryReleaseShared(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
}
