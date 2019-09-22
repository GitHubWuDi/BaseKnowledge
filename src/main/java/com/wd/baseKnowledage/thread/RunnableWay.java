package com.wd.baseKnowledage.thread;

public class RunnableWay  {

	
	public class RunnableTest implements Runnable{
		@Override
		public void run() {
           for (int i = 0; i < 100; i++) {
        	   try {
	                Thread.sleep(100) ;
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            } 
	           System.out.println(i); 
		   }			
		}
	}
	
    public void testRunable(){
    	RunnableTest test = new RunnableTest();
    	Thread thread = new Thread(test, "RunableTest");
    	thread.currentThread().setName("RunableTest");
    	System.out.println("name:"+Thread.currentThread().getName());
    	thread.start();
    }
    
    public static void main(String[] args) {
		new RunnableWay().testRunable();
	}
}
