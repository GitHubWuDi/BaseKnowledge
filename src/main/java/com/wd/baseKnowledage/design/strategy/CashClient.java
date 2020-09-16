package com.wd.baseKnowledage.design.strategy;

import java.util.Scanner;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月16日 上午9:35:52
* 类说明
*/
public class CashClient {

	public static void main(String[] args) {
		 
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("请商品单价输入：");
		double price = scanner1.nextDouble();
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("请商品购买数：");
		int count = scanner2.nextInt();
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("请商品活动类型：");
		String type = scanner3.next();
		
		CashContext cashContext = new CashContext(type);
		double result = cashContext.getResult(price*count);
		System.out.println(result);
		
	}
	
	
}
