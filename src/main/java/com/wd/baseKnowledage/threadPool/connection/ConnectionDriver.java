package com.wd.baseKnowledage.threadPool.connection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年2月3日 下午4:09:32
* 类说明    Connection连接类 co
*/
public class ConnectionDriver {
     
	static class ConnectionHandler implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(method.getName().equals("commit")){ //
				Thread.sleep(100);
			}
			return null;
		}
	}
	public static Connection createConnection(){
		return (Connection)Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class<?>[] { Connection.class }, new ConnectionHandler());
	}
}
