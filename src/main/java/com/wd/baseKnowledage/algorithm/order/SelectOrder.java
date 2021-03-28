package com.wd.baseKnowledage.algorithm.order;

/**
 * 选择排序
 * 思路：每一轮遍历将最小的那个一个排到左侧位置
 * 时间复杂度O(N2)
 * 空间复杂度O(1)
 * @author Administrator
 *
 */
public class SelectOrder {

	public static void test(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < array.length; j++) {
				minIndex = array[minIndex]<array[j]?minIndex:j;
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex]=temp;
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {1,2,5,3,6,8,3,7};
		test(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	
}
