package com.wd.baseKnowledage.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author wudi
 * @version 创建时间：2018年5月17日 下午11:21:24
 * @ClassName 类名称
 * @Description 类描述
 */
public class PredicateTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		PredicateTest predicateTest = new PredicateTest();
		List<Integer> conditionFilter = predicateTest.conditionFilter(list, integer -> integer > 5);
		conditionFilter.forEach(System.out::println);
	}

	public List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
		return list.stream().filter(predicate).collect(Collectors.toList());
	}

	/**
	 * negate就是将当前条件取反
	 * @param list
	 * @param predicate
	 * @return
	 */
	public List<Integer> conditionFilterNegate(List<Integer> list, Predicate<Integer> predicate) {
		return list.stream().filter(predicate.negate()).collect(Collectors.toList());
	}
   
	/**
	 * 且条件满足
	 * @param list
	 * @param predicate
	 * @param predicate2
	 * @return
	 */
	public List<Integer> conditionFilterAnd(List<Integer> list, Predicate<Integer> predicate,
			Predicate<Integer> predicate2) {
		return list.stream().filter(predicate.and(predicate2)).collect(Collectors.toList());
	}
	
	/**
	 * 或条件满足
	 * @param list
	 * @param predicate
	 * @param predicate2
	 * @return
	 */
	public List<Integer> conditionFilterOr(List<Integer> list, Predicate<Integer> predicate,Predicate<Integer> predicate2){
	    return list.stream().filter(predicate.or(predicate2)).collect(Collectors.toList());
	}

}
