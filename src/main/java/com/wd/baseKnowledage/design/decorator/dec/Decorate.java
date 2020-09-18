package com.wd.baseKnowledage.design.decorator.dec;

import com.wd.baseKnowledage.design.decorator.Component;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月18日 上午8:48:50
* 类说明
*/
public abstract class Decorate extends Component {

	 protected Component component;
	 
	 public Decorate(Component component) {
		 this.component = component;
	 }
	
	 public void operation() {
		 if(component!=null) {
			 component.operation();
		 }
	 }
	
}
