package com.wd.baseKnowledage.algorithm.array;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月30日 上午8:39:26
* 习题说明：在数组中第k个最小的值
*/
public class FindSmallK {

	/**
	 * 方法功能： 在数组Array当中找出第k小的值
	 * 输入参数：array为整数组，low为数组起始小标，high为数据右边界下标，k为整数
	 * @param arr
	 * @param low
	 * @param high
	 * @param k
	 */
	public static int  findSmallK(int arr[],int low,int high,int k) {
		int i,j,splitElem;
		i = low;
		j = high;
		splitElem =arr[i];
		//把小于等于splitElem的数放在数组中splitElem的左边，大于splitElem的值放到右边
		while(i<j) {
			while(i<j&&arr[j]>=splitElem) {
				j--;
				if(i<j) {
					arr[i++] = arr[j];
				}
			}
			while(i<j&&arr[i]<=splitElem) {
				i++;
				if(i<j) {
					arr[j--] = arr[i];
				}
			}
		}
		arr[i] = splitElem;
		//splitElem在子数组array[low~high]中下标的偏移量
		int subArrayIndex = i-low;
		//splitElem在子数组array[low~high]中所在位置恰好为k-1，那么它就是第k小的元素
		if(subArrayIndex==k-1) {
			return arr[i];
		}
		//splitElem在子数组array[low~high]中所在位置恰d大于k-1，那么只需在array[low~i-1]中找第k小个元素
		else if(subArrayIndex>k-1) {
			return findSmallK(arr,low,i-1,k);
		}
		//在array[i+1~high]中找第k-i+low-1小的元素
		else {
			return findSmallK(arr,i+1,high,k-(i-low)-1);
		}
	} 
	
	/**
	 * 在O（N）时间复杂度内查找数组中前三名。
	 * @param arr
	 */
	public static void findTop3(int[] arr) {
		if(arr==null || arr.length<3) {
			System.out.println("参数不合法");
			return;
		}
		int r1,r2,r3;
		r1 =r2=r3=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>r1) {
				r3 = r2;
				r2 = r1;
				r1 = arr[i];
			}else if(arr[i]>r2&&arr[i]!=r1) {
				r3 = r2;
				r2 = arr[i];
			}else if(arr[i]>r3&&arr[i]!=r2) {
				r3  =arr[i];
			}
		}
		System.out.println("前三名分别为："+r1+","+r2+","+r3);
	}
	
	public static void main(String[] args) {
		int k = 3;
		int array[] = {4,0,1,0,2,3};
		findTop3(array);
		System.out.println("第"+k+"小的值为："+findSmallK(array, 0, array.length-1, k));
		
	}
	
}
