package com.wd.baseKnowledage.design.state;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午9:20:45
* 类说明
*/
public class Client {

	public static void main(String[] args) {
		Work work = new Work();
		work.setHour(9);
		work.writeProgram();
		work.setHour(12);
		work.writeProgram();
		work.setHour(13);
		work.writeProgram();
		work.setHour(15);
		work.writeProgram();
		work.setHour(17);
		work.writeProgram();
		work.setFinish(false);
		work.setHour(19);
		work.writeProgram();
		work.setHour(22);
		work.writeProgram();
	}
	
	
}
