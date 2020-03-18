package com.wd.baseKnowledage.thread;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2019年9月29日 下午5:58:57
* 类说明   线程中断实例  线程中断命令只是给当前运行的线程一个标识，标识其具有中断属性，具体是否操作由设计人实现
*/
public class ThreadInterruptTest {
    
	
	
	   
	public static void main(String[] args) throws InterruptedException {
		     
		   Thread thread = new MyThread("t1");
		   System.out.println(thread.getName() +" ("+thread.getState()+") is new."); 
		   thread.start();
		   System.out.println(thread.getName() +" ("+thread.getState()+") is started.");
		   Thread.sleep(3000);
		   thread.interrupt(); //发送线程中断的命令
		   System.out.println(thread.getName() +" ("+thread.getState()+") is interrupted.");
		   Thread.sleep(300);
		   System.out.println(thread.getName() +" ("+thread.getState()+") is interrupted now.");
	   }

 
      public static class MyThread extends Thread{
    	  
	       public MyThread(String threadName) {
	    	    super(threadName);   
	       }
          
	       @Override
	       public void run(){
	    	   int i = 0;
	    	 try {
	    		 Thread.sleep(1000);
	    	     while(!isInterrupted()){ //表示没有被中断
	    	    	 Thread.sleep(100); // 休眠100ms
	    	    	 i++;
	    	    	 System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);  
	    	     }
	          }catch(InterruptedException e){
	        	  System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
	    	 }
      }
	
    }
}