package com.wd.baseKnowledage.dataStructor.lineStructor.orderStructor;

import java.lang.reflect.Array;

import lombok.Data;

/**
 * 顺序存储结构
 * @author Administrator
 *
 */
@Data
public class OrderStorageStructor<T> {
    
	
	public  Integer maxSize =10000; //数组的长度
	
	public  Integer length = 0; //当前的长度 
	
	public T[] dataArray;
	
	
	

	public OrderStorageStructor(Integer maxSize) {
		this.maxSize = maxSize;
		this.length = 0;
	}
	
	
	
	
	

	
	
	/**
	 * 顺序结构获得对应位置上面的数据
	 * @param tArray
	 * @param i
	 * @return
	 */
	public  T getElem(int i) {
		if(dataArray.length==0 || i> dataArray.length || i<0) {
			throw new RuntimeException("error,please check!");
		}
		T t = dataArray[i-1];
		
		return t;
	}


	/**
	 * 插入某一个元素
	 * @param array
	 * @param i
	 * @param t
	 */
	public  void insertElem(int i, T t) {
		if(this.length==maxSize  || i<1 || i> this.length+1) {
			throw new RuntimeException("error,please check!");
		}	
		
		if(i<=this.length) {
			for (int j = this.length-1; j >= i; j--) {
				dataArray[j+1] = dataArray[j];
			}
			dataArray[i] = t;
			this.length++;
		}
	}
	
	
	public  void deleteElem(int i) {
		if(this.length==maxSize  || i<1 || i> this.length) {
			throw new RuntimeException("error,please check!");
		}	
		
		if(i<this.length) {
			for (int j = i; j < this.length; j++) {
				dataArray[j] = dataArray[j+1];
			}
		}
		this.length--;
	
	}
	
	
	
	
}
