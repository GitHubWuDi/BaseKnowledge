package com.wd.baseKnowledage.design.protoType;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月23日 上午8:56:52
* 类说明
*/
public class WorkExperience implements Cloneable {

	private String workDate;
	private String company;
	
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	 @Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}
