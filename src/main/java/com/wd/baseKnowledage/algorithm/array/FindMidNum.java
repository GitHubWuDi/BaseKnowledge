package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2021年1月25日 下午6:58:12
* 类说明   如何在不排序的情况下 发现数组当中的中位数
*/
public class FindMidNum {

	private int pos = 0;
	
	private void partition(int[] arr,int low,int high) {
		int key =arr[low];
		while(low<high) {
			while(low<high&&arr[high]>key) {
				high--;
			}
			arr[low] =arr[high];
			while(low<high&&arr[low]<key) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = key;
		pos = low;
	}
	
	
	public int getMid(int[] arr) {
		int low = 0;
		int n = arr.length;
		int high = n-1;
		int mid = (low+high)/2;
		while(true) {
			/*以arr[low]为基准把数组分为两部分*/
			partition(arr, low, high);
			if(pos==mid) { /*找到中位数*/
				break;
			}else if(pos>mid) {
				high = pos-1;
			}else{
				low = pos+1;
			}
		}
		return (n%2)!=0?arr[mid]:(arr[mid]+arr[mid+1])/2;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {7,5,3,1,11,9,2};
		FindMidNum findMidNum = new FindMidNum();
		int mid = findMidNum.getMid(arr);
		System.out.println(mid);
	}
	
	
}
