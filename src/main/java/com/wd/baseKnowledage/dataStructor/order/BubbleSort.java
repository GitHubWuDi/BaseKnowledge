package com.wd.baseKnowledage.dataStructor.order;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年8月12日 上午10:37:42
* 类说明
*/
public class BubbleSort {

	
	public void bubbleSort(SqList sqlList) {
		Integer length = sqlList.getLength();
		Integer[] intArray = sqlList.getIntArray();
		boolean flag = true;
		for (int i = 1; i < length&&flag; i++) {
			flag = false;
			for (int j = length-1; j >= i; j--) {
				if(intArray[j-1]>intArray[j]){
					sqlList.swap(j-1, j);
					flag = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SqList sqlList = new SqList();
		Integer[] initArray = {2,4,5,7,3,5,7,8,9,0};
		sqlList.setIntArray(initArray);
		sqlList.setLength(10);
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(sqlList);
		Integer[] intArray = sqlList.getIntArray();
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
			
		}
	}
	
	
}
