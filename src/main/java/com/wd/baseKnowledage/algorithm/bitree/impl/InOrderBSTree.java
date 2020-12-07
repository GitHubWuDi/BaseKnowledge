package com.wd.baseKnowledage.algorithm.bitree.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月7日 上午8:52:46
* 类说明   如何将二叉树转换为双向链表
* 使用两个变量pHead与pEnd分别指向链表的头结点与尾结点。那么在遍历root结点时，只需要将root结点的lchild指向pEnd，把pEnd的rchild（右）指向root；此时root结点就被加入到双向链表里了。因此，root变成了双向链表的尾结点。
* 对于所有的结点都可以通过同样的方法来修改结点的指向。因此，可以采用递归的方法来求解，在求解时需要特别注意递归的结束条件和边界情况（例如双向链表为空的时候）。
*/

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

public class InOrderBSTree {

	
	private static BiTNode pHead = null;  //双向链表头结点
	private static BiTNode pEnd = null; //双向链表尾结点
	
	public static void inOrderBSTree(BiTNode root) {
		
		if(null==root){
			return;
		}
		
		inOrderBSTree(root.lchild);
		root.lchild = pEnd; //使当前结点的左孩子指向双向链表中最后一个结点
		if(null==pEnd) { //双向列表为空，当前遍历的结点为双向链表的头结点
			pHead = root;
		}else {   //使双向链表中最后一个结点的右孩子指向当前结点
			pEnd.rchild = root; 
		}
		pEnd=root; //将当前结点设为双向链表中最后一个结点
		inOrderBSTree(root.rchild);
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		BiTNode root = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		inOrderBSTree(root);
		BiTNode cur = null;
		System.out.println("转换后双向链表正向遍历");
		for (cur=pHead;cur!=null;cur=cur.rchild) {
			System.out.println(cur.data+" ");
		}
		System.out.println();
		System.out.println("转换后双向链表逆向遍历");
		for (cur=pEnd;cur!=null;cur=cur.lchild) {
			System.out.println(cur.data+" ");
		}
		
	}
	
}
