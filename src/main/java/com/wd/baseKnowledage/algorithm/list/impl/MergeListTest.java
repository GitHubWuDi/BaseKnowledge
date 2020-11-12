package com.wd.baseKnowledage.algorithm.list.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月12日 下午4:38:03
* 类说明
* 给定一个有序链表，其中每个结点也表示一个有序链表，结点包含两个类型的指针：
1）指向主链表中下一个结点的指针（在下面的代码中称为“正确”指针）。
2）指向此结点头的链表（在下面的代码中称之为“down”指针）。编排化处理
*/
public class MergeListTest {

	private Node head;
	
	public class Node{
		public int data;
		public Node right;
		public Node down;
		
		public Node(int data) {
			this.data = data;
			this.right = null;
			this.down = null;
		}
		
	}
	
	/**
	 * 合并a链表和b链表
	 * @param a
	 * @param b
	 * @return
	 */
	private Node merge(Node a,Node b) {
		if(a==null) {
			return b;
		}
		if(b==null) {
			return a;
		}
		/*将两个链表结点当中较小的那个赋值给result*/
		Node result = null;
		if(a.data<b.data) {
			result = a;
			result.down = merge(a.down, b);
		}else {
			result = b;
			result.down = merge(a, b.down);
		}
		return result;
	}
	
	/*把链表扁平化处理*/
    private Node flatten(Node root) {
        if(root==null ||root.right==null) {
        	return root;
        }
        root = merge(root, root.right);
    	root.right = flatten(root.right);
    	return root;
    }	
	
    
    public Node insert(Node head_ref,int data) {
    	Node newNode = new Node(data);
    	newNode.down = head_ref;
    	head_ref = newNode;
    	return head_ref;
    }
    
    
    public void printList() {
    	Node tmp = head;
    	while(tmp!=null) {
    		System.out.println(tmp.data+"");
    		tmp = tmp.down;
    	}
    	System.out.println();
    }
    
    
    
    
    public static void main(String[] args) {
    	MergeListTest 	merge = new MergeListTest();
    	merge.head = merge.insert(merge.head, 31);
    	merge.head = merge.insert(merge.head, 8);
    	merge.head = merge.insert(merge.head, 6);
    	merge.head = merge.insert(merge.head, 3);
    	
    	merge.head.right = merge.insert(merge.head.right, 21);
    	merge.head.right = merge.insert(merge.head.right, 11);
    	
    	
    	merge.head.right.right = merge.insert(merge.head.right.right, 50);
    	merge.head.right.right = merge.insert(merge.head.right.right, 22);
    	merge.head.right.right = merge.insert(merge.head.right.right, 15);
    	
    	
    	merge.head.right.right.right = merge.insert(merge.head.right.right.right, 55);
    	merge.head.right.right.right = merge.insert(merge.head.right.right.right, 40);
    	merge.head.right.right.right = merge.insert(merge.head.right.right.right, 39);
    	merge.head.right.right.right = merge.insert(merge.head.right.right.right, 30);
    	
    	merge.head = merge.flatten(merge.head);
    	
    	merge.printList();
	}
}
