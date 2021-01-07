package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2021年1月7日 上午8:42:06
* 类说明 如何求数组中绝对值最小的数
*/
public class FindMinAbsNum {

	
	public static int findMinAbsNum1(int[] arr) {
		if(arr==null || arr.length<=0) {
			System.out.println("输入参数不合理");
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(Math.abs(arr[i])<Math.abs(min)) {
				min = arr[i];
			}
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {-10,-5,4,5,7,9};
		int num = findMinAbsNum1(arr);
		System.out.println("绝对值最小的数为："+num);
	}
	
}
