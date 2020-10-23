package com.wd.baseKnowledage.design.protoType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月23日 上午8:55:38
* 类说明
*/
public class Resume implements Cloneable {

	private static Logger logger = LoggerFactory.getLogger(Resume.class);
	
	private String name;
	private String sex;
	private String age;
	private WorkExperience workExperience;
	
	public Resume(String name) {
		this.name = name;
		workExperience = new WorkExperience();
	}
	
	public Resume(WorkExperience work) {
		this.workExperience = (WorkExperience)work.clone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public WorkExperience getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}
	
	public void setPersonInfo(String sex,String age) {
		this.sex =sex;
		this.age =age;
	}
	
	public void setWorkExperience(String workDate,String conmpany) {
		 workDate = workExperience.getWorkDate();
		 conmpany = workExperience.getCompany();
	}
	
	public void display() {
		logger.info("姓名:{},性别:{},年龄:{}",name,sex,age);
		logger.info("工作经历：:{},{}",workExperience.getCompany(),workExperience.getWorkDate());
	}
	
}
