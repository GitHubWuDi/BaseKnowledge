package com.wd.baseKnowledage.dataStructor.order;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年9月1日 上午8:39:20
* 类说明   插入排序
*/
public class InsertSort {

	
	/**
	 * 插入排序
	 * @param sqlList
	 */
	public void insertSort(SqList sqlList) {
		Integer[] intArray = sqlList.getIntArray();
		int i,j;
		for ( i = 1; i < sqlList.getLength(); i++) {
			if(intArray[i]<intArray[i-1]){
				intArray[0] = intArray[i];
				for (j = i-1; intArray[j]>intArray[0]; j--) {
					intArray[j+1] = intArray[j];
				}
				intArray[j+1] = intArray[0];
			}
		}
	}
	
	
	public void insertSort1(SqList sqlList) {
		Integer[] intArray = sqlList.getIntArray();
		for (int i = 1; i < intArray.length; i++) {
			int j = i;
			while(j > 0){
				if (intArray[j] < intArray[j-1]) {
					sqlList.swap(j, j-1);
					j--;
				}else {
					break;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		SqList sqlList = new SqList();
		Integer[] initArray = {2,4,5,7,3,5,7,8,9,0};
		sqlList.setIntArray(initArray);
		sqlList.setLength(10);
		InsertSort insertSort = new InsertSort();
		insertSort.insertSort1(sqlList);
		Integer[] intArray = sqlList.getIntArray();
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
			
		}
	}
	
	
	
}
