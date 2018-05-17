package com.wd.baseKnowledage.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
* @author wudi
* @version 创建时间：2018年5月17日 下午11:08:27
* @ClassName 类名称
* @Description 类描述
*/
public class IterateLambdaTest {

	   public static void main(String[] args) {
		List<String> list = Arrays.asList("1","2","3","4","5");
		list.forEach(n->System.out.println(n));
		
		list.forEach(System.out::println);
		
	}
	   
}
