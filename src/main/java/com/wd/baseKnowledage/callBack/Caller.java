package com.wd.baseKnowledage.callBack;

/**
 * 调用者
 * 
 * @author wudi
 * @version 创建时间：2018年5月16日 下午10:26:00
 * @ClassName 类名称
 * @Description 类描述
 */
public class Caller implements CallBack {

	private Callee callee;

	public Caller(Callee callee) {
		this.callee = callee;
	}

	public void askQuestion(String question) {
		 System.out.println("question is:"+question);
		new Thread(new Runnable() {
			@Override
			public void run() {
				callee.executionQuestion(Caller.this, question);
			}
		}).start();
		play();
	}

	public void play() {
		System.out.println("我有事先出去，请留言");
	}

	@Override
	public void solve(String result) {
		System.out.println(result);
	}

}
