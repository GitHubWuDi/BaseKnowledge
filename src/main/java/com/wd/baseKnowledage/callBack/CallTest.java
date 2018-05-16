package com.wd.baseKnowledage.callBack;
/**
* @author wudi
* @version 创建时间：2018年5月16日 下午10:37:23
* @ClassName 类名称
* @Description 类描述
*/
public class CallTest {
    public static void main(String[] args) {
		Callee callee = new Callee(); //被调用者
		Caller caller = new Caller(callee); //调用者-----（调用）-----被调用者
		caller.askQuestion("1+1 =?");
		
	}
}
