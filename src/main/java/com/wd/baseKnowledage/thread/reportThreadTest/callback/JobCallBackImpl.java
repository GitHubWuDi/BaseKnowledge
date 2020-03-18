package com.wd.baseKnowledage.thread.reportThreadTest.callback;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年3月6日 下午4:12:37
* 类说明   推送回调接口
*/
public class JobCallBackImpl implements JobCallBack<Boolean> {

	@Override
	public void callBack(Boolean t) {
          System.out.println("推送报表，结果："+t);
	}

}
