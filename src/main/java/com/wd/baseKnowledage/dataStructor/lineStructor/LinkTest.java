package com.wd.baseKnowledage.dataStructor.lineStructor;

import org.junit.Before;
import org.junit.Test;

import com.wd.baseKnowledage.dataStructor.lineStructor.linkedList.LinearLinkedList;

public class LinkTest {
     
	private LinearLinkedList<String> root = new LinearLinkedList<String>();
	
	@Before
	public void initData() {
		LinearLinkedList<String> node1 = new LinearLinkedList<>();
		LinearLinkedList<String> node2 = new LinearLinkedList<>();
		LinearLinkedList<String> node3 = new LinearLinkedList<>();
		LinearLinkedList<String> node4 = new LinearLinkedList<>();
		root.setData("root");
		node1.setData("node1");
		node2.setData("node2");
		node3.setData("node3");
		node4.setData("node4");
		root.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		root = new LinearLinkedList<String>(root);
		
	}
	
	@Test
	public void testGetElem() {
		String elem = root.getElem(2);
		System.out.println(elem);
	}
	
	
	@Test
	public void testInsertElem() {
		root.insertElem(3, "nodex");
		System.out.println(root);
	}
	
	
	@Test
	public void testDeleteElem() {
		root.deleteElem(2);
		System.out.println(root);
	}
	
}
