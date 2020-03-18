package com.wd.baseKnowledage.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class RecursiveTest {

	public static String MAP_NAME_TYPE = "com.google.gson.internal.LinkedTreeMap";
	public static String ARRAY_LIST = "java.util.ArrayList";
	
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
//		RecursiveVO recursiveVO = getRecursive();
//		Gson gson = new Gson();
//		String json = gson.toJson(recursiveVO);
//		Map fromJson = gson.fromJson(json, Map.class);
//		System.out.println(fromJson);
//		String [] keys = {"a4","b1"}; //a4.b1
//		
//		String resultByRecursive = getResultMapTypeByRecursive(fromJson, keys,0);
//		System.out.println(resultByRecursive);
		
		List<String> list = extractMessageByRegular("当前交换机端口数据端口值:${log.assetGuid},,资产guid:${log.ifEntryList[0].ifIndex}", "\\$\\{(.|\\r\\n)+?}");
		System.out.println(list);
		
		
	}
	
	/**
	 * 关于map当中递归的解决方法,增加动态的参数int i（递归是Map类型）
	 * @param fromMap
	 * @param keys
	 * @param i
	 * @return
	 */
	public static String getResultMapTypeByRecursive(Map fromMap,String[] keys,int i){ //如何解決传参的问题
		String key = keys[i];   //
		if(key.contains("[")&&key.contains("]")){  //包括括号
			List<String> list = extractMessageByRegular(key,"\\w+"); //含有对应的key和下标
			key = list.get(0);//key
			String num = list.get(1); //下标
			Object object = fromMap.get(key);
			String typeName = object.getClass().getTypeName();
			if(typeName.equals(ARRAY_LIST)){   //List结构
				List array = (List)object;
				Object arrayValue = array.get(Integer.valueOf(num));
				Map arrayMap = (Map)arrayValue;
				return getResultMapTypeByRecursive(arrayMap, keys,i+1);				
			}else{
				return String.valueOf(object);  //这个地方就是出口
			}
		}else {
			Object object = fromMap.get(key);
			String typeName = object.getClass().getTypeName();
			if(typeName.equals(MAP_NAME_TYPE)){   //Map结构
				Map map = (Map)object;
				return getResultMapTypeByRecursive(map, keys,i+1);				
			}else{
				return String.valueOf(object);  //这个地方就是出口
			}			
		}
		
		
	}
	
	
	/**
	 * 解析字符串当中的中括号
	 * @param msg
	 * @return
	 */
	public static List<String> extractMessageByRegular(String msg,String patternStr){
		 List<String> list=new ArrayList<String>();
		    Pattern p = Pattern.compile(patternStr);  //\\[\\w+\\]   \\w+
		    Matcher m = p.matcher(msg);
		    while(m.find()){
		      list.add(m.group());
		    }
		    return list;
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
		List<RecursiveArrayVO> list = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			RecursiveArrayVO recursiveArrayVO = new RecursiveArrayVO();
			recursiveArrayVO.setC1("c1");
			recursiveArrayVO.setC2("c2");
			recursiveArrayVO.setC3("c3");
			list.add(recursiveArrayVO);
		}
		recursiveVO.setA5(list);
		return recursiveVO;
	}
	
	
	
	
}
