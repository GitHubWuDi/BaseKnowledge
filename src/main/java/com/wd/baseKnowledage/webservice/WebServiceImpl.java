package com.wd.baseKnowledage.webservice;
/**
* @author wudi
* @version 创建时间：2018年5月22日 下午10:44:45
* @ClassName 类名称
* @Description 类描述
*/
@javax.jws.WebService
public class WebServiceImpl implements WebService {

	@Override
	public String helloWorld() {
		System.out.println("hello world");
		return "hello world";
	}

}
