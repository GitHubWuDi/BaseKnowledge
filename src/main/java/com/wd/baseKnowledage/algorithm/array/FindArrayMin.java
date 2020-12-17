package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月17日 上午8:48:55
* 如何找到旋转数组的最小值
*/
public class FindArrayMin {

	public static int getMin(int[] arr,int low,int high) {
		//如果旋转个数为0，即没有旋转，单独处理，直接返回数组头元素
		if(high<low) {
			return arr[0];
		}
		//只剩一个元素一定是最小值
		if(high==low) {
			return arr[low];
		}
		//mid = (low+high)/2,采用下面的写法防止溢出
		int mid = low+((high-low)>>1);
		if(arr[mid]<arr[mid-1]) { //判断是否arr[mid]为最小值
			return arr[mid];
		}else if(arr[mid+1]<arr[mid]) {
			return arr[mid+1];
		}else if(arr[high]>arr[mid]) { //最小值在左半部分
			return getMin(arr, low, mid-1);
		}else if(arr[mid]>arr[low]) {
			return getMin(arr, mid+1, high);
		}else {   //这种情况无法确定最小值所在位置，需要在左右不分分别进行查找
			return Math.min(getMin(arr, low, mid-1), getMin(arr, mid+1, high));
		}
	}
	
	public static void swap(int[] arr,int low,int high) {
		//交换数组low到high的内容
		for (;low < high;low++,high--) {
			int tmp  = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
		}
	}
	
	/**
	 * 先分别把两个子数组的内容交换，然后把整个数组的内容交换，即可得到问题的解。
	 * 以数组x1{1,2,3,4,5}与数组x2{6,7,8,9}为例，交换两个数组后，
	 * x1={5，4，3，2，1}，x2={9， 8，7，6}，即x={5，4，3，2，1，9，8，7，6}。交换整个数组后，x={6，7，8，9，1，2， 3，4，5}。
	 * @param arr
	 * @param div
	 */
	public static void rotateArr(int[] arr,int div) {
		if(null==arr || div<0||div>=arr.length) {
			System.out.println("参数不合法");
			return;
		}
		if(div==0 || div==arr.length-1) {
			return;
		}
		swap(arr, 0, div);
		swap(arr, div+1, arr.length-1);
		swap(arr, 0, arr.length-1);
	}
	
	
	
	
	public static int getMin(int[] arr) {
		if(null==arr) {
			System.out.println("参数不合法");
			return -1;
		}else {
			return getMin(arr, 0, arr.length-1);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5,6,7,8,1,2,3};
		int min = getMin(array);
		System.out.println(min);
		
		System.out.println();
		System.out.println("旋转过后：");
		rotateArr(array, 2);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
}
