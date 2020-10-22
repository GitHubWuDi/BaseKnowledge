package com.wd.baseKnowledage.design.visitor;

import com.wd.baseKnowledage.design.visitor.pImpl.Man;
import com.wd.baseKnowledage.design.visitor.pImpl.Woman;
import com.wd.baseKnowledage.design.visitor.vImpl.Failed;
import com.wd.baseKnowledage.design.visitor.vImpl.Success;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年10月22日 上午9:03:27
* 类说明 客户端调用
*/
public class Client {
 
	public static void main(String[] args) {
		ObjectStructure objectStructure = new ObjectStructure();
		objectStructure.attach(new Man());
		objectStructure.attach(new Woman());
		
		Success success = new Success();
		objectStructure.display(success);
		
		
		
		Failed failed = new Failed();
		objectStructure.display(failed);
		
	}
	
	
}
