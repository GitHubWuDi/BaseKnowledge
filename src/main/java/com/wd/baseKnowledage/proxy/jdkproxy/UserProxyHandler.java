package com.wd.baseKnowledage.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.wd.baseKnowledage.proxy.model.User;
import com.wd.baseKnowledage.proxy.service.UserService;
import com.wd.baseKnowledage.proxy.service.UserServiceImpl;

/**
 * 使用JDK反射实现动态代码（业务实现类代码）的方式
 * @author Administrator
 *
 */
public class UserProxyHandler implements InvocationHandler {

	
	private UserService userService = new UserServiceImpl();
	
	@Override
	public Object invoke(Object obj, Method method, Object[] params) throws Throwable {
		if(method.getName().equals("addUser")){
			User user = (User)params[0];
			System.out.println("name:"+user.getName()+" entry into addUser method");
		   return method.invoke(userService, params);
		}else if(method.getName().equals("getUser")){
			System.out.println("entry into getUser method");
			return method.invoke(userService, params);
		}
		return null;
	}

}
