package com.wd.baseKnowledage.proxy.cglibProxy;

import com.wd.baseKnowledage.proxy.model.User;
import com.wd.baseKnowledage.proxy.service.UserService;
import com.wd.baseKnowledage.proxy.service.UserServiceImpl;

/**
* @author wudi
* @version 创建时间：2018年5月24日 下午11:21:39
* @ClassName 类名称
* @Description 类描述
* 字节码生成技术实现AOP，其实就是继承被代理对象，然后Override需要被代理的方法，在覆盖该方法时，自然是可以插入我们自己的代码的。
* 因为需要Override被代理对象的方法，所以自然CGLIB技术实现AOP时，就 必须要求需要被代理的方法不能是final方法，因为final方法不能被子类覆盖 。
*/
public class CGProxyTest {

	public static void main(String[] args) {
		Object proxyedObject = new UserServiceImpl();	// 被代理的对象
		CGProxy cgProxy = new CGProxy(proxyedObject);
		UserService proxyObject = (UserService) cgProxy.getProxyObject();
		proxyObject.getUser("123");
		proxyObject.addUser(new User());
	}
	
}
