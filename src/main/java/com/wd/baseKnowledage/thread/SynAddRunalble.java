package com.wd.baseKnowledage.thread;

/**
* @author wudi
* @version 创建时间：2018年6月28日 下午10:49:44
* @ClassName 类名称
* @Description 类描述
*/
public class SynAddRunalble implements Runnable {
     
	private int a,b;

	public  SynAddRunalble(int a,int b){
		this.a =a;
		this.b = b;
	}

	@Override
	public void run() {
        synchronized (Integer.valueOf(a)) {
			synchronized (Integer.valueOf(b)) {
				System.out.println(a+b);
			}
		}		
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new SynAddRunalble(1, 2)).start();
			new Thread(new SynAddRunalble(2, 1)).start();;
		}
	}
	
}
