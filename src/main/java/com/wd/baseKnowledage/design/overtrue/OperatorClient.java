package com.wd.baseKnowledage.design.overtrue;

import java.util.Scanner;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月15日 上午9:14:58
* 类说明
*/
public class OperatorClient {

	
	public static void main(String[] args) {
		Scanner inputA = new Scanner(System.in);
		System.out.println("请输入第一个数字是：");
		double nextDoubleA = inputA.nextDouble();
		Scanner inputB = new Scanner(System.in);
		System.out.println("请输入第二个数字是：");
		double nextDoubleB = inputB.nextDouble();
		OperatorFactory operatorFactory = new OperatorFactory();
		double exexOperator = operatorFactory.exexOperator(nextDoubleA, nextDoubleB, "+");
		System.out.println("计算器输出结果为："+exexOperator);
	}
	
	
}
