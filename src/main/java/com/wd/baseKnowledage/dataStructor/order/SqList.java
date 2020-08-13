package com.wd.baseKnowledage.dataStructor.order;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年8月12日 上午10:24:54
* 类说明
*/
public class SqList {

	private static final Integer MAX_SIZE = 10;
	
	private  Integer[] intArray = new Integer[MAX_SIZE];
	
	private  Integer length;
	
	
	/**
	 * 进行交换
	 * @param intArray
	 * @param i
	 * @param j
	 */
	public void swap(int i,int j){
		int temp = intArray[i];
		intArray[i] = intArray[j];
		intArray[j]=temp;
	}
	

	public Integer[] getIntArray() {
		return intArray;
	}

	public void setIntArray(Integer[] intArray) {
		this.intArray = intArray;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	
	
}
