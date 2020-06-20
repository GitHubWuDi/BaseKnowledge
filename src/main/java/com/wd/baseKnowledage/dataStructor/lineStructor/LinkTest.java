package com.wd.baseKnowledage.dataStructor.lineStructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.wd.baseKnowledage.dataStructor.lineStructor.linkedList.LinearLinkedList;
import com.wd.baseKnowledage.dataStructor.lineStructor.linkedList.StaticLinear;

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
	
	
	@Test
	public void testCreateListHead() {
		LinearLinkedList<String> node = new LinearLinkedList<>();
		root=node.insertListHead(root, "node0");
		System.out.println(root);
	}
	
	
	@Test
	public void testCreateListTail() {
		LinearLinkedList<String> node = new LinearLinkedList<>();
		root=node.insertListTail(root, "node0");
		System.out.println(root);
	}
	
	@Test
	public void testInitStacks() {
		
		List<StaticLinear<String>> list = new ArrayList<>();
		StaticLinear<String> linear = new StaticLinear<String>();
		StaticLinear<String> linear1 = new StaticLinear<String>(10);
		
		for (int i = 0; i < 10; i++) {
			list.add(linear);
		}
		
		StaticLinear<String>[] staticLinears=list.toArray(new StaticLinear[list.size()]);
		linear1.initList(staticLinears);
		System.out.println(staticLinears);
	}
	
	
	@Test
	public void testCleanList() {
		LinearLinkedList<String> node = new LinearLinkedList<>();
		node.clearList(root);
		System.out.println(root);
	}
	
	
}
