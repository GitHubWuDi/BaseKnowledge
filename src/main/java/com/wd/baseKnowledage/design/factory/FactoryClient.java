package com.wd.baseKnowledage.design.factory;

import java.util.Scanner;

import com.wd.baseKnowledage.design.factory.create.OperatorFactory;
import com.wd.baseKnowledage.design.factory.create.impl.AddOperatorFactory;
import com.wd.baseKnowledage.design.factory.create.impl.DevisionOperatorFactory;
import com.wd.baseKnowledage.design.factory.create.impl.MuitlOperatorFactory;
import com.wd.baseKnowledage.design.factory.create.impl.SubOperatorFactory;
import com.wd.baseKnowledage.design.factory.product.Operator;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月23日 上午8:59:00
* 类说明 客户端调用
*/
public class FactoryClient {

	
	public static void main(String[] args){
		OperatorFactory operatorFactory = null;
		Operator operator1 = null;
		Scanner scanner1  = new Scanner(System.in);
		System.out.println("请输入第一个值：");
		double element1 = scanner1.nextDouble();
		Scanner scanner2  = new Scanner(System.in);
		System.out.println("请输入第2个值：");
		double element2 = scanner2.nextDouble();
		Scanner scanner3  = new Scanner(System.in);
		System.out.println("请输入运算符：");
		String operator = scanner3.next();
		switch (operator) {
		case "+":
		   operatorFactory = 	new AddOperatorFactory(element1, element2);
		   operator1 = operatorFactory.createOperatorFactory();
			break;
        case "-":
        	 operatorFactory = 	new SubOperatorFactory(element1, element2);
  		     operator1 = operatorFactory.createOperatorFactory();
			break;
        case "*":
        	 operatorFactory = 	new MuitlOperatorFactory(element1, element2);
 		     operator1 = operatorFactory.createOperatorFactory();
			break;
        case "%":
        	 operatorFactory = 	new DevisionOperatorFactory(element1, element2);
		     operator1 = operatorFactory.createOperatorFactory();
			break;
		default:
			break;
		}
		double result = operator1.getResult();
		System.out.println("最终结果："+result);
	}
	
	
}
