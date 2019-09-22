package com.wd.baseKnowledage.thread;

import java.io.IOException;

/**
 *     守护线程
 * @author Administrator
 *
 */
public class DaemonThread extends Thread {
  public DaemonThread() { 
        
    } 
    
    public void run() { 
        for (int i = 0 ; i < 100 ; i ++) { 
            try {
                Thread.sleep(100) ;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            System.out.println(i);   
        }
    } 
            
    public static void main (String args[]) { 
    	DaemonThread test = new DaemonThread() ; 
        test.setDaemon(false) ;  //true:守护线程，false:用户线程
        test.start() ; 
        System.out.println("isDaemon=" + test.isDaemon()); 
      //如果没有下面这一段说明test就是一个守护线程，JVM将会自动退出，加上这一段以后
        // 变成了用户线程,jvm的GC就是守护线程进行垃圾回收操作
        try {
            System.in.read() ;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
