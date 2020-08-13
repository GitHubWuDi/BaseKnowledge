package com.wd.baseKnowledage.dataStructor.order;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年8月13日 上午10:02:38
* 类说明
*/
public class SimpleSort {

	/**
	 * 简单排序，时间复杂度为O(n2)
	 * @param sqlList
	 */
	public void simpleSort(SqList sqlList){
		int min  = 0;
		Integer length = sqlList.getLength();
		Integer[] intArray = sqlList.getIntArray();
		for (int i = 0; i < length; i++) {
			min = i;
			for (int j = i+1; j <length; j++) {
				if(intArray[min]>intArray[j]) {
					min = j;
				}
			}
			if(i!=min){
				sqlList.swap(i, min);
			}
		}
	}
	
	
	public static void main(String[] args) {
		SqList sqlList = new SqList();
		Integer[] initArray = {2,4,5,7,3,5,7,8,9,0};
		sqlList.setIntArray(initArray);
		sqlList.setLength(10);
		SimpleSort simpleSort = new SimpleSort();
		simpleSort.simpleSort(sqlList);
		Integer[] intArray = sqlList.getIntArray();
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
			
		}
	}
	
	
}
