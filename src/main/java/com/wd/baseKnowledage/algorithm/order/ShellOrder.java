package com.wd.baseKnowledage.algorithm.order;

/**
 * 希尔排序
 * 思想：像这样逐步分组进行粗调，再进行直接插入排序的思想
 * 上面示例中所使用的分组跨度（4，2，1），被称为希尔排序的增量，
 * 增量的选择可以有很多种，我们在示例中所用的逐步折半的增量方法，是Donald Shell在发明希尔排序时提出的一种朴素方法，被称为希尔增量。
 * 低于时间复杂度O（N2）,空间复杂度O(1)
 * 
 * @author Administrator
 *
 */
public class ShellOrder {

	public static void sort(int[] array) {
		int d = array.length;
		while(d>1) {
			d = d/2;
			for (int x = 0; x < d; x++) {
				for (int i = x+d; i < array.length; i=i+d) {
					int temp = array[i];
					int j;
					for (j = i-d; j>=0&&array[j]>temp; j=j-d) {
						array[j+d]=array[j];
					}
					array[j+d] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,5,3,6,8,3,7};
		sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	
}
