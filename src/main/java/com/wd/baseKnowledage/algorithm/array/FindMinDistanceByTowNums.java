package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2021年1月4日 上午8:48:49
* 类说明：如何求数组中两个元素的最小距离
*/
public class FindMinDistanceByTowNums {

	/**
	 * 通过动态规划完成数组中两个元素的最小距离
	 * @param arr
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int minDistance(int[] arr,int num1,int num2) {
		if(arr==null || arr.length==0) {
			System.out.println("参数不合理");
			return Integer.MAX_VALUE;
		}
		int lastPost1 = -1; //上次遍历到num1的位置
		int lastPost2 = -1; //上次遍历到num2的位置
		int minDis = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==num1) {
				lastPost1 = i;
				if(lastPost2>0) {
					minDis = Math.min(minDis, lastPost1-lastPost2);
				}
			}
			
			if(arr[i]==num2) {
				lastPost2 = i;
				if(lastPost1>0) {
					minDis = Math.min(minDis, lastPost2-lastPost1);
				}
			}
		}
		return minDis;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {4,5,6,4,7,7,9,7,8,3,5,4};
		int minDistance = minDistance(arr, 4, 8);
		System.out.println("最小距离："+minDistance);
	}
	
}
