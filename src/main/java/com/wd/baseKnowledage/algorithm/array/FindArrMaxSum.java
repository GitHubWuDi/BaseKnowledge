package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2021年1月8日 上午8:43:32
* 类说明     如何求数组最大和
* 方案1：可以采用动态规划的方法来降低算法的时间复杂度。实现思路如下。
		首先可以根据数组的最后一个元素arr[n-1]与最大子数组的关系分为以下三种情况讨论：
		1）最大子数组包含arr[n-1]，即最大子数组以arr[n-1]结尾。
		2）arr[n-1]单独构成最大子数组。
		3）最大子数组不包含arr[n-1]，那么求arr[1…n-1]的最大子数组可以转换为求arr[1…n-2]的最大子数组。
*/
public class FindArrMaxSum {

	   public static int maxSubArray1(int[] arr) {
		   if(arr==null||arr.length<1) {
			   System.out.println("参数不合法");
			   return -1;
		   }
		   int n =arr.length;
		   int[] end = new int[n];
		   int[] all = new int[n];
		   end[n-1] = arr[n-1];
		   all[n-1] = arr[n-1];
		   end[0] = all[0] = arr[0];
		   for (int i = 1; i < n; i++) {
			       end[i] = Integer.max(end[n-1]+arr[i], arr[i]);
			       all[i] = Integer.max(end[i], all[i-1]);
		   }
		   return all[n-1];
	   }
	
	   /**
	    * 优化的动态规划方法
	    * 方法三中每次其实只用到了 End[i-1]与 All[i-1]，而不是整个数组中的值，因此，可以定义两个变量来保存End[i-1]与All[i-1]的值，并且可以反复利用。
	    * @param arr
	    * @return
	    */
	   public static int maxSubArray2(int[] arr) {
		   if(arr==null||arr.length<1) {
			   System.out.println("参数不合法");
			   return -1;
		   }
		   int nAll = arr[0];
		   int nEnd = arr[0];
		   for (int i = 1; i < arr.length; i++) {
			nEnd = Integer.max(nEnd+arr[i],arr[i]);
			nAll = Integer.max(nEnd, nAll);
		}
		   return nAll;
	   }
	   
	   public static void main(String[] args) {
		int[] arr = {1,-1,3,4,-8,9};
		int maxSubArray = maxSubArray1(arr);
		System.out.println("数组最大和:"+maxSubArray);
		
	}
	   
}
