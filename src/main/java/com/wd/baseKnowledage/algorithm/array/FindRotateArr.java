package com.wd.baseKnowledage.algorithm.array;
/**
 *    如何对数组旋转
 * @author Administrator
 *
 */
public class FindRotateArr {

	public static void rotateArr(int[][] arr) {
		int row,col;
		int len  = arr.length;
		//打印二维数组右上部分
		for (int i = len-1; i >0; i--) {
			row = 0;
			col  = i;
			while(col<len)
			{
				System.out.print(arr[row++][col++]+"");
			}
			System.out.println();
		}
		//打印二维数组左下半部分
		for (int i = 0; i <len; i++) {
			row = i;
			col = 0;
			while(row<len)
			{
				System.out.print(arr[row++][col++]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		rotateArr(arr);
	}
	
}
