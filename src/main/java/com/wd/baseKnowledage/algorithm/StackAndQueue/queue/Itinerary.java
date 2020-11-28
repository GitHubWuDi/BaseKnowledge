package com.wd.baseKnowledage.algorithm.StackAndQueue.queue;

import java.util.HashMap;
import java.util.Map;

/**
 * 如何从给定的车票中找出旅程
 * 给定一趟旅途旅程中所有的车票信息，根据这个车票信息找出这趟旅程的路线。例如，给定下面的车票：（“西安”到“成都”），（“北京”到“上海”），（“大连”到“西安”），（“上海”到“大连”）。
 * 那么可以得到旅程路线为：北京→上海，上海→大连，大连→西安，西安→成都。假定给定的车票不会有环，也就是说，有一个城市只作为终点而不会作为起点。
 * @author Administrator
 *
 */
public class Itinerary {

	private static void printResult(Map<String,String> input) {
		Map<String,String> reverseInput = new HashMap<>();  //用来存储把input键值调换后进行调换的存储空间
		
		for (Map.Entry<String, String> entry: input.entrySet()) {
			reverseInput.put(entry.getValue(), entry.getKey());
		}
		String start  = null;
		for (Map.Entry<String, String> entry: input.entrySet()) {
			if(!reverseInput.containsKey(entry.getKey())){ 
				start = entry.getKey();
				break;
			}
		}
		if(start==null) {
			System.out.println("输入不合理");
			return;
		}
		
		/*起点出发按照顺序进行遍历*/
		String to = input.get(start);
		System.out.print(start+"->"+to);
		start = to;
		to = input.get(to);
		while(to!=null) {
			System.out.print(","+start+"->"+to);
			start = to;
		    to  = input.get(to);
		}
	}
	
	
	public static void main(String[] args) {
		Map<String,String> input = new HashMap<>();
		input.put("武汉", "北京");
		input.put("北京", "上海");
		input.put("无锡", "武汉");
		printResult(input);
	}
	
}
