package com.wd.baseKnowledage.recursive;

import java.util.Map;

import com.google.gson.Gson;

public class RecursiveTest {

	public static String MAP_NAME_TYPE = "com.google.gson.internal.LinkedTreeMap";
	
	/*
	 关于 递归中 递进和回归的理解*/
	public static void recursion_display(int n) {
	    int temp=n;//保证前后打印的值一样
	     System.out.println("递进:" + temp);
	    if (n > 0) {
	        recursion_display(--n);
	    }
	    System.out.println("回归:" + temp);
	}
	
	
	public static int fib(int n) throws Exception {
	    if (n < 0)
	        throw new Exception("参数不能为负！");
	    else if (n == 0 || n == 1)
	        return n;
	    else
	        return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) throws Exception {
		RecursiveVO recursiveVO = getRecursive();
		Gson gson = new Gson();
		String json = gson.toJson(recursiveVO);
		Map fromJson = gson.fromJson(json, Map.class);
		System.out.println(fromJson);
		String [] keys = {"a4","b1"};
		String resultByRecursive = getResultByRecursive(fromJson, keys,0);
		System.out.println(resultByRecursive);
	}
	
	/**
	 * 关于map当中递归的解决方法,增加动态的参数int i
	 * @param fromMap
	 * @param keys
	 * @param i
	 * @return
	 */
	public static String getResultByRecursive(Map fromMap,String[] keys,int i){ //如何解決传参的问题
		Object object = fromMap.get(keys[i]);
		String typeName = object.getClass().getTypeName();
		if(typeName.equals(MAP_NAME_TYPE)){   //Map结构
			Map map = (Map)object;
			return getResultByRecursive(map, keys,i+1);				
		}else{
			return String.valueOf(object);
		}
		
	}
	
	
	
	
	public static RecursiveVO getRecursive(){
		RecursiveVO recursiveVO = new RecursiveVO();
		RecursiveChildVO recursiveChildVO = new RecursiveChildVO(); 
		recursiveChildVO.setB1("b1");
		recursiveChildVO.setB2("b2");
		recursiveChildVO.setB3("b3");
		recursiveVO.setA1("a1");
		recursiveVO.setA2("a2");
		recursiveVO.setA3("a3");
		recursiveVO.setA4(recursiveChildVO);
		return recursiveVO;
	}
	
	
	
	
}
