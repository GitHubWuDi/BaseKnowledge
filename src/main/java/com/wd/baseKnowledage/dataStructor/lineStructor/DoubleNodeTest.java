package com.wd.baseKnowledage.dataStructor.lineStructor;

import org.junit.Before;
import org.junit.Test;

import com.wd.baseKnowledage.dataStructor.lineStructor.linkedList.DoubleNode;

public class DoubleNodeTest {

	
	
      private DoubleNode<String> doubleNodes = new DoubleNode<String>();
	
	
     @Before
	public void initDoubleNode(){
		DoubleNode<String> node1  = new DoubleNode<String>();
		DoubleNode<String> node2  = new DoubleNode<String>();
		DoubleNode<String> node3  = new DoubleNode<String>();
		node1.setData("node1");
		node2.setData("node2");
		node3.setData("node3");
		
		node1.setNext(node2);
		node2.setNext(node3);
		
		
		
		node3.setPrior(node2);
		node2.setPrior(node1);
		
		//doubleNodes = new DoubleNode<String>(node1);
		
		System.out.println(node1);
	}
	
     @Test
     public void testInsertDoubleNode(){
//    	// doubleNodes.insertElem(2, "node4");
//    	 System.out.println(doubleNodes);
     }
     
     
}
