package com.wd.baseKnowledage.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
* @author wudi
* @version 创建时间：2018年6月28日 下午9:46:16
* @ClassName 类名称
* @Description 用来测试HashMap，TreeMap,LinkedHashMap
*/
public class MapTest {

	public static void main(String[] args) throws IOException {
		//treeMapTest();
		//hashMapTest();
		//deadCircule();
		MapTest mapTest = new MapTest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			reader.readLine();
			int a  = (int)Math.round(Math.random()*1000);
			int b  = (int)Math.round(Math.random()*1000);
			System.out.println(mapTest.add(a, b));
		}
		
		
		
	}
	private static void hashMapTest() {
		Map<String,Object> hashMap= new HashMap<>();
		hashMap.put("2", "qq2");
		hashMap.put("1", "qq1");
		hashMap.put("3", "qq3");
		hashMap.put("4", "qq4");
		
		Iterator<Map.Entry<String, Object>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			System.out.println("key:"+entry.getKey()+","+"value:"+entry.getValue());;
		}
		
		
//		for (String str : hashMap.keySet()) {
//			System.out.println("key:"+str);
//		}
		/*for(Entry<String, Object> entry:hashMap.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key:"+key+","+"value:"+value);
		}*/
	}
	
	
	private static void deadCircule(){
		while(true){
			try {
				Thread.sleep(3*1000);
				System.gc();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void treeMapTest() {
		Map<String,Object> treeMap= new TreeMap<>();
		treeMap.put("3", "qq3");
		treeMap.put("1", "qq1");
		treeMap.put("2", "qq2");
		treeMap.put("4", "qq4");
		for(Entry<String, Object> entry:treeMap.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key:"+key+","+"value:"+value);
		}
	}
	
	public int add(int a,int b){
		return a+b;
	}
	
	
}
