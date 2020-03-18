package com.wd.baseKnowledage.thread.reportThreadTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wudi E-mail:wudi891012@163.com
 * @version 创建时间：2020年3月5日 上午10:20:29 类说明
 */
public class DownLoadReportImpl {
      
	
	private List<String> runningTasks = new ArrayList<>();
	private Map<String,Object> map = new ConcurrentHashMap<>();   //生成报表的缓存
	
	/**
	 * 当生存报表只需要2s，直接返回报表的文件信息
	 */
	public void downLoadReportBy2Secs() {
		long beginTime = System.currentTimeMillis();
		System.out.println("开始生成报表");
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("生成报表结束，花费的时间是：" + (endTime - beginTime) / 1000 + "s");
	}

	/**
	 * 当生存报表需要4s，3s后返回提示信息。并在4s的时候执行消息推送
	 * 
	 * @param name
	 * @return
	 */
	public boolean downLoadReport(String name,Integer seconds,Integer count) {
		long beginTime = System.currentTimeMillis(); // 开始时间
		String uuid = UUID.randomUUID().toString();
		if(map.containsKey(name)&&map.get(name)!=null) {
			System.out.println(name+seconds+"s"+count+"次 "+"报表存在该缓存当中，不需要生成！");
			return true;
		}else {
			if(runningTasks.contains(name)){
				System.out.println(name+seconds+"s"+count+"次 "+"该报表下载任务正在生成的过程，请稍后！");
				return false;
			}else {
				System.out.println(name+seconds+"s"+count+"次 "+"该报表下载任务开始创建");
				System.out.println(name+seconds+"s"+count+"次 "+"任务加入到正在生成的队列当中");
				runningTasks.add(name);
				try {
					Thread.sleep(seconds * 1000); // 报表生成需要时间
				} catch (InterruptedException e) {
					System.out.println(name+" is interrupted when calculating, will stop...");
				}
				map.put(name, uuid);
				System.out.println(name+"报表已经缓存");
				runningTasks.remove(name);
				System.out.println(name+seconds+"s"+count+"次 "+"报表已结束，从正在生成的队列当中删除");
				long endTime = System.currentTimeMillis(); // 结束时间
				System.out.println(name+seconds+"s"+count+"次 "+"报表生成结束时间：" + (endTime - beginTime) + "ms");
				return true; // 反应完成返回结果值
			}
		}
	}
	
	
	
	
	

}
