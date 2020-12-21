package com.wd.baseKnowledage.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月21日 上午8:51:14
* 问题说明：如何找出数组中出现奇数次的数
* 数组中有N+2个数，其中，N个数出现了偶数次，两个数出现了奇数次（这两个数不相等），
* 请用O（1）的空间复杂度，找出这两个数。注意：不需要知道具体位置，只需要找出这两个数。
* 这种方法对数组进行了一次遍历，时间复杂度为O（n）。但是申请了额外的存储过程来记录数据出现的情况，因此，空间复杂度为O（n）。
*/
public class FindOddNum {

	
	
	public static void getNum(int[] arr) {
		if(arr==null || arr.length==0) {
			System.out.println("参数不合理");
			return;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i],1);
			}else {
				Integer val = map.get(arr[i]);
				map.put(arr[i],val+1);
			}
		}
		 for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			 Integer key = entry.getKey();
			 Integer value = entry.getValue();
			 if(value.equals(1) || value%2==1) {
				 System.out.println("key = "+key+" and value = "+entry.getValue());
			 }
		 }
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,3,4,4,5,5,5};
		getNum(arr);
	}
	
}
