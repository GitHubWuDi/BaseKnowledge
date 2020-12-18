package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月18日 上午8:16:44
* 如何找到丢失的数
* 给定一个由n-1个整数组成的未排序的数组序列，其元素都是1到n中的不同的整数。请写出一个寻找数组序列中缺失整数的线性时间算法。
*/
public class FindLostNum {

	
	/**
	 * 如何找到丢失的数(首先分析一下数学性质。假设缺失的数字是X，那么这n-1个数一定是1～n之间除了X以外的所有数。
	 * 试想一下，1～n一共n个数的和是可以求出来的，数组中的元素的和也是可以求出来的)
	 * @param arr
	 * @return
	 */
	public static int getSum(int[] arr) {
		if(arr==null||arr.length==0) {
			return -1;
		}
		int sum = 0;
		int sumb = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			sumb+=i;
		}
		sumb = sumb+arr.length+arr.length+1;
		int lost = sumb-sum;
		return lost;
	}
	
	
	/**
	 * 通过异或的方案进行对应的判断操作
	 * @param arr
	 * @return
	 */
	public static int getNums(int[] arr) {
		if(arr==null || arr.length==0) {
			System.out.println("参数不合理");
			return -1;
		}
		int a  = arr[0],b=1;
		int i;
		int len = arr.length;
		for (i=1; i < len; i++) {
			a = a^arr[i];
		}
		for ( i=2; i <= len+1; i++) {
			b = b^i;
		}
		return a^b;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,6};
		int sum = getSum(arr);
		System.out.println("丢失的数据为："+sum);
		
		int nums = getNums(arr);
		System.out.println("异或丢失数据为："+nums);
		
		int num = 3^7;
		System.out.println(num);
	}
	
	
}
