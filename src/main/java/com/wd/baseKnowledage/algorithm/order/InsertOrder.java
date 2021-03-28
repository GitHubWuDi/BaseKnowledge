package com.wd.baseKnowledage.algorithm.order;

/**
 * 插入排序
 * 思想：维护一个有序区，把元素一个一个插入到有序区的位置，直到所有元素都有序为止
 * 时间复杂度O(N2)
 * 空间复杂度O(1)
 * @author Administrator
 *
 */
public class InsertOrder {

	public static void test(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int insertValue = array[i];
            int j = i-1;
			//从右向左比较元素的同时，进行元素复制
			for (; j >=0&&insertValue<array[j]; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = insertValue;
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
