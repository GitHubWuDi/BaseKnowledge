package com.wd.baseKnowledage.algorithm.array;
/**
 * 如何在有规律的二维数组中进行高效的数据查找
 * 题目描述：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 实现一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 解题思路：
 * 1.给定数组array（行数：rows，列数：columns，待查找元素：data）
 * 2.遍历数组右上角的元素（i=0，j=columns-1），如果array[i][j]==data，则在二维数组中找到了data直接返回；如果array[i][j]＞data，则说明这一列其他的数字也一定大于data。因此，没有必要在这一列继续查找了，通过j--操作排除这一列。
 * 3.通过j--操作排除这一列。同理，如果array[i][j]＜data，则说明这一行中其他数字也一定比 data 小，因此，没有必要再遍历这一行了，可以通过 i++操作排除这一行。
 * @author Administrator
 *
 */
public class FindElementByBinaryArr {

	public static boolean findWithBinary(int[][] array,int data) {
		if(array==null) {
			return false;
		}
		//从二维数组右上角开始遍历
		int i = 0;
		int rows = array.length; //行
		int columns = array[0].length; //列
		int j = columns-1;
		while(i<rows&&j>=0) {
			if(array[i][j]==data) {
				return true;
			}else if(array[i][j]>data) {
				--j;
			}else {
				++i;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int[][] array = {
				{0,1,2,3,4,5},
				{10,11,12,13,14,15},
				{20,21,22,23,24,25},
				{30,31,32,33,34,35},
				{40,41,42,43,44,45}
		};
		boolean result1 = findWithBinary(array, 13);
		boolean result2 = findWithBinary(array, 27);
		System.out.println("result1:"+result1);
		System.out.println("result2:"+result2);
	}
	
	
}
