package com.wd.baseKnowledage.algorithm.array;

import java.util.Hashtable;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月15日 上午9:07:15
* 问题描述：如何找出数组当中唯一的重复元素
*/
public class FindDupElem {

	
	/**
	 * 采用hashTable，申请额外空间完成异或处理
	 * @param array
	 * @return
	 */
	public static int findDup1(int[] array) {
		if(array==null) {
			return -1;
		}
		int len = array.length;
		Hashtable<Integer,Integer> hashTable = new Hashtable<>();
		for (int i = 0; i < len; i++) {
			hashTable.put(i, 0);
		}
		
		for (int i = 0; i < array.length; i++) {
			if(hashTable.get(array[i]-1)==0) {
				hashTable.put(array[i]-1, array[i]-1);
			}else {
				return array[i];
			}
		}
		return -1;
	}
	
	/**
	 * 通过异或的方式进行处理
	 * 即将数组里的元素逐一进行异或运算，得到的值再与数字1、2、3、…、N进行异或运算，得到的最终结果即为所求的重复元素。
	 * 以数组{1, 3, 4, 2, 5, 3}为例。（1^3^4^2^5^3）^（1^2^3^4^5）=（1^1）^（2^2）^（3^3^3）^（4^4）^（5^5）=0^0^3^0^0=3。
	 * @param array
	 * @return
	 */
	public static int findDup2(int[] array) {
		if(array==null) {
			return -1;
		}
		int len = array.length;
		int result = 0;
		int i;
		for ( i = 0; i < len; i++) {
			result^=array[i];
		}
		for ( i = 1; i < array.length; i++) {
			result^=i;
		}
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		int array[] = {4,3,4,1};
		System.out.println("重复元素1为："+findDup1(array));
		System.out.println("重复元素2为："+findDup2(array));
		
	}
}
