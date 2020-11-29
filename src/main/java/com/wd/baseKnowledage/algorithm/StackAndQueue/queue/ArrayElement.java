package com.wd.baseKnowledage.algorithm.StackAndQueue.queue;

import java.util.HashMap;
import java.util.Map;

/**
    *     题目描述：如何从数组中找出满足a+b=c+d的两个数对
    *     给定一个数组，找出数组中是否有两个数对（a, b）和（c, d），
    *     使得a+b=c+d，其中a、b、c和d是不同的元素。如果有多个答案，打印任意一个即可。例如，给定数组：{3, 4, 7, 10, 20, 9, 8}，可以找到两个数对（3, 8）和（4, 7），使得3+8=4+7。
    *
    *     解题思路：
    以数对为单位进行遍历，在遍历过程中，把数对和数对的值存储在哈希表中（键为数对的和，值为数对）。当遍历到一个键值对，如果它的和在哈希表中已经存在，那么就找到了满足条件的键值对。
    时间复杂度为：
    这种方法的时间复杂度为O（N2）。因为使用了双重循环，而HashMap的插入与查找操作实际的时间复杂度为O（1）。
 * @author Administrator
 *
 */
public class ArrayElement {

	private static Map<Integer,Pair> element = new HashMap<>();
	
	
	
	static class Pair{
		public Pair(Integer first,Integer second) {
			this.first = first;
			this.second = second;
		}
		private Integer first;
		private Integer second;
		
		public Integer getFirst() {
			return first;
		}
		public void setFirst(Integer first) {
			this.first = first;
		}
		public Integer getSecond() {
			return second;
		}
		public void setSecond(Integer second) {
			this.second = second;
		}
		
		
	}
	
	/**
	 * 发现对应的对数
	 * @param arr
	 * @return
	 */
	public boolean findPair(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				Integer sum = arr[i]+arr[j];
				if(!element.containsKey(sum)){
					element.put(sum, new Pair(arr[i], arr[j]));
				}else {
					System.out.println("对数为"+"{"+element.get(sum).getFirst()+","+element.get(sum).getSecond()+"}"+","+"{"+arr[i]+","+arr[j]+"}");
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		ArrayElement arrayElement  = new ArrayElement();
		int[] elems = {1,2,3,4};
		arrayElement.findPair(elems);
	}
	
	
	
}
