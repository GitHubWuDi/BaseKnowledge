package com.wd.baseKnowledage.algorithm.order;
/**
 * 归并排序
 * 时间复杂度（O（nlogn））
 * 空间复杂度（O(n)）
 * 归并操作需要哪三个步骤呢？我们以两个长度为4的集合为例：
 * 
 * @author Administrator
 *
 */
public class MergeSort {

	
	
	public static void mergeSort(int[] array,int start,int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(array,start,mid);
			mergeSort(array, mid+1, end);
			//把两个有序的小集合，归并成一个大集合
			merge(array,start,mid,end);
		}
	}

	private static void merge(int[] array, int start, int mid, int end) {
		int [] tempArray = new int[end-start+1];
		int p1 =start,p2=mid+1,p=0;
		while(p1<=mid&&p2<=end) {
			if(array[p1]<=array[p2]) {
				tempArray[p++]=array[p1++];				
			}else {
				tempArray[p++]=array[p2++];
			}
		}
		//左侧小集合还有剩余，依次放入大集合尾部
		while(p1<=mid) {
			tempArray[p++]=array[p1++];
		}
		//右侧小集合还有剩余，依次放入大集合尾部
		while(p2<=end) {
			tempArray[p++]=array[p2++];
		}
		//把大集合的元素复制回原数组
		for (int i = 0; i < tempArray.length; i++) {
			array[i+start] = tempArray[i];
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,5,3,6,8,3,7};
		mergeSort(array,0,array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
