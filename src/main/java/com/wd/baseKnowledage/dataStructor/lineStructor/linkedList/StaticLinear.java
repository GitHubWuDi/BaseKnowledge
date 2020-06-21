package com.wd.baseKnowledage.dataStructor.lineStructor.linkedList;

public class StaticLinear<T> {

	private T data;
	private int cur;
	private Integer maxSize;
	
	
	public StaticLinear(Integer maxSize,T data) {
		this.maxSize = maxSize;
		this.data = data;
	}

	public StaticLinear() {
		
	}
	
	public StaticLinear(Integer maxSize) {
		this.maxSize = maxSize;
	}
	
	
	public void initList(StaticLinear<T>[] space) {
		for (int i = 0; i < maxSize-1; i++){
			space[i] = new StaticLinear<T>();
			space[i].setCur(i+1);
		}
		space[maxSize-1]= new StaticLinear<T>();
		space[maxSize-1].setCur(maxSize-1);
	}
	
	
	public void listInsert(StaticLinear<T>[] space) {
		
	}
	
	

	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public int getCur() {
		return cur;
	}


	public void setCur(int cur) {
		this.cur = cur;
	}


	public Integer getMaxSize() {
		return maxSize;
	}


	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}
	
	
	
	
	
}
