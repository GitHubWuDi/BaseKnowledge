package com.wd.baseKnowledage.thread.reportThreadTest.future;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

import com.wd.baseKnowledage.util.DateUtil;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月6日 下午2:03:58
* 类说明
*/
public class TaskTest implements Callable<Boolean> {

	private Map<String,Object> map = new HashMap<>();
	@Override
	public Boolean call() {
		System.out.println("线程启动");
		long beginTime = System.currentTimeMillis();
		String uuid = UUID.randomUUID().toString();
		try {
			Thread.sleep(3001);
		} catch (InterruptedException e) {
			System.out.println("thread is interrupted when calculating, will stop...");
		}
		System.out.println("callable继续执行的时间："+DateUtil.format(new Date()));
		map.put("key", uuid);
		long endTime = System.currentTimeMillis();
		System.out.println("花费时间："+(endTime-beginTime)+"ms");
		System.out.println("线程结束");
		return true;
	}

}
