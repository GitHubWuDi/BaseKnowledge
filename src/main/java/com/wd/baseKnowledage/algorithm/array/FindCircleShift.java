package com.wd.baseKnowledage.algorithm.array;
/**
 * 如何对数组进行循环移位
 * 反转法：把数组看成由两段组成的，记为XY。左旋转相当于要把数组XY变成YX。先在数组上定义一种翻转的操作，就是翻转数组中数字的先后顺序。把X翻转后记为XT。显然有（XT）T=X。
 * 首先对X和Y两段分别进行翻转操作，这样就能得到XTYT。接着再对XTYT进行翻转操作，得到（XTYT）T=（YT）T（XT）T=YX。正好是期待的结果。
 * @author Administrator
 *
 */
public class FindCircleShift {

	
	public static void reverse(int arr[],int start,int end) {
		while(start<end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}
	
	public static void rightshift(int[] arr,int k) {
		if(arr==null) {
			System.out.println("参数不合法");
			return;
		}
		int len  = arr.length;
		k%=len;
		reverse(arr, 0, len-k-1);
		reverse(arr, len-k, len-1);
		reverse(arr, 0, len-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		rightshift(arr, 3);
		System.out.println("反转后："+arr);
	}
	
}
