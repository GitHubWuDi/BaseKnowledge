package com.wd.baseKnowledage.threadPool.connection;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年2月3日 下午3:09:24
* 类说明    数据库连接池示例
*/

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
      private LinkedList<Connection> pool = new LinkedList<>();
      
      public ConnectionPool(int ConnectionPool){
    	  if(ConnectionPool>0){
    		  for (int i = 0; i < 10; i++) {
    			  pool.add(ConnectionDriver.createConnection());			
			}
    	  }
      }
      /**
       * 释放一个数据库链接
       * @param connection
       */
      public void releaseConnection(Connection connection){
    	  if(connection!=null){
    		  synchronized (pool) {
				pool.addLast(connection); //在线程池当中新增一个链接
				pool.notifyAll(); //通知等待方
			}
    	  }
      }
      /**
       * 在mills内无法获取到连接，将返回null(等待超时模式)
       * @param mills
       * @return
     * @throws InterruptedException 
       */
      public Connection fetchConnection(long mills) throws InterruptedException{
    	  synchronized (pool) {
			if(mills<=0){
				while(pool.isEmpty()){
					pool.wait();  //pool进入到等待的状态
				}
				return pool.removeFirst();
			}else{
				long deadLine = System.currentTimeMillis()+mills; //deadLine
				long remainingTime = mills;
				while(pool.isEmpty()&&remainingTime>0){
					pool.wait(mills);
					remainingTime = deadLine-System.currentTimeMillis();
				}
				Connection result = null;
				if(!pool.isEmpty()){
					result = pool.removeFirst();
				}
				return result;
			}
		}
      }
      
      
      
}
