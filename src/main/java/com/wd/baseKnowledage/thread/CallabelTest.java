package com.wd.baseKnowledage.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallabelTest implements Callable<String> {
    
	private String content;
	
	 public CallabelTest(String content) {
		 this.content = content;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return content+" hello callable content";
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallabelTest callabelTest = new CallabelTest("wudi,");
		long beginTime  = System.currentTimeMillis();
		FutureTask<String> ft = new FutureTask<String>(callabelTest);
		Thread thread = new Thread(ft, "callabelTest");
		thread.start();
		String content = ft.get();
		long endTime  = System.currentTimeMillis();
		System.out.println("return result:"+content);
		System.out.println("spend Time:"+(endTime-beginTime)/1000+" seconds");
	}
	
	

}
