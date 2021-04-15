package com.wd.baseKnowledage.algorithm.math;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * 如何只使用++操作符实现加减乘除运算
 * @author Administrator
 *
 */
public class Arithmetic {

	/**
	 * 1）加法操作。实现a+b的基本思路为对a执行b次++操作即可。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a,int b) {
		if(a<0&&b<0) {
			System.out.println("无法用++操作实现");
			return -1;
		}
		if(b>=0) {
			for (int i = 0; i < b; i++) {
				a++;
			}
			return a;
		}else {
			for (int i = 0; i < a; i++) {
				b++;
			}
			return b;
		}
	}
	/**
	 * 2）减法操作。实现a-b（a≥b）的基本思路为：不断对b执行++操作，直到等于a为止，在这个过程中记录执行++操作的次数。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int minus(int a,int b) {
		if(a<b) {
			System.out.println("无法用++操作实现");
			return -1;
		}
		int result = 0;
		for (; b!=a; b++,result++) {
			
		}
		return result;
	}
	
	
}
