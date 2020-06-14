package com.wd.baseKnowledage.dataStructor.lineStructor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.wd.baseKnowledage.dataStructor.lineStructor.orderStructor.OrderStorageStructor;
/**
 * 单元测试工作
 * @author Administrator
 *
 */
public class LinerTest {

	
	private OrderStorageStructor<String> orderStorageStructor;
	private String[] dataArray;
	
	@Before
	public void initOrderStorageStructor(){
		orderStorageStructor = new OrderStorageStructor<String>(20); 
		Integer maxSize = orderStorageStructor.getMaxSize();
		String[] dataArray = new String[maxSize];
		for (int i = 0; i < 5; i++) {
			dataArray[i] =String.valueOf(i);
		}
		orderStorageStructor.setDataArray(dataArray);
		orderStorageStructor.setLength(5);
	}
	
	
	/**
	 * 获取元素
	 */
	@Test
	public void testGetElem() {
		String elem = (String) orderStorageStructor.getElem(2); //2表示第二个元素
		assertEquals("2", elem);
	}
	
	/**
	 * 测试插入元素
	 */
	@Test
	public void testInsertElem() {
		orderStorageStructor.insertElem(2,"4"); //2表示第二个元素
		for (int i = 0; i < orderStorageStructor.dataArray.length; i++) {
			String string = dataArray[i];
			System.out.println(string);
		}
	}
	
	@Test
	public void testDeleteElem() {
		orderStorageStructor.deleteElem(1);
		for (int i = 0; i < orderStorageStructor.dataArray.length; i++) {
			String string = dataArray[i];
			System.out.println(string);
		}
	}
	
	
	
}
