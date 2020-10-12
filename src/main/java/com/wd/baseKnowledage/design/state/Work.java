package com.wd.baseKnowledage.design.state;

import com.wd.baseKnowledage.design.state.impl.ForenoonState;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月12日 上午8:46:35
* 类说明
*/
public class Work {

	private State current;
	
	public Work() {
		current = new ForenoonState();
	}
	
	
	private int hour;
	private boolean finish;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	public State getCurrent() {
		return current;
	}
	
	public void setCurrent(State current) {
		this.current = current;
	}
	
	public void writeProgram() {
		current.writeProgram(this);
	}
	
	
	
	
}
