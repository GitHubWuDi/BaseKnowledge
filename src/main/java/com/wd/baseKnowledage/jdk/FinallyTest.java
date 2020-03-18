package com.wd.baseKnowledage.jdk;

/**
 * @author wudi E-mail:wudi891012@163.com
 * @version 创建时间：2019年10月10日 上午10:49:11 类说明
 */
public class FinallyTest {

	public static void main(String[] args) {

		getNumbers();

	}

	private static Integer getNumbers() {
		try {
			int test=5/0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("the number is " + 4);
		}
		
		try {
           System.out.println("test"+1);
		} catch (Exception e) {

		} finally {
			System.out.println("the number is " + 5);
			return 5;
		}

	}

}
