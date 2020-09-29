package com.wd.baseKnowledage.design.component;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月29日 上午10:02:51
* 类说明
*/
public class FinanceDepartment extends Company {

	public FinanceDepartment(String name) {
		super(name);
	}

	@Override
	public void add(Company c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Company c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disPlay(int depth) {
       System.out.println(Util.getDepth(depth)+name);		
	}

	@Override
	public void lineOfDuty() {
       System.out.println(name+"公司财务收支管理");		
	}

}
