package com.wd.baseKnowledage.thread;

/**
 * 关于ThreadLocal相关的测试工作
 * @author Administrator
 *
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
    	
    	@Override
    	protected Integer initialValue(){
    		return 0;//通过initialValue方法设置默认值
    	}
    };
    
    
    public static void main(String[] args) {
		
    	for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(){
				@Override
				public void run(){
					int num = THREAD_LOCAL_NUM.get()+5;
					System.out.println("currrentThreadName:"+Thread.currentThread().getName()+" value:"+num);
				}
				
			};
			thread.start();
		}
    	
	}
    
    
    
	
	
}
