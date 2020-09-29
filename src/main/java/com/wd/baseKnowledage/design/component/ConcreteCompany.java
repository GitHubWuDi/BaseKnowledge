package com.wd.baseKnowledage.design.component;


import java.util.ArrayList;
import java.util.List;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午9:41:32
* 类说明
*/
public class ConcreteCompany extends Company {

	private List<Company> children = new ArrayList<>();
	
	public ConcreteCompany(String name) {
		super(name);
	}

	@Override
	public void add(Company c) {
		children.add(c);
	}

	@Override
	public void remove(Company c) {
		children.remove(c);
	}

	@Override
	public void disPlay(int depth) {
         System.out.println(Util.getDepth(depth)+name);
         for (Company company : children) {
        	 company.disPlay(depth+2);
		}
	}



	@Override
	public void lineOfDuty() {
       for (Company company : children) {
    	   company.lineOfDuty();
	   }
	}

}
