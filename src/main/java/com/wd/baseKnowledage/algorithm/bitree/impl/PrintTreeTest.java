package com.wd.baseKnowledage.algorithm.bitree.impl;

import java.util.LinkedList;
import java.util.Queue;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月4日 上午8:57:37
* 题目说明:如何从顶部开始逐步打印二叉树的结点数据
* 解题思路：为了实现对二叉树的层序遍历，就要求在遍历一个结点的同时记录下它的孩子结点的信息，
* 然后按照这个记录的顺序来访问结点的数据，在实现的时候可以采用队列来存储当前遍历到的结点的孩子结点，从而实现二叉树的层序遍历。
* 算法性能：O(N)
*/
public class PrintTreeTest {

	
	public static void printTreeLayer(BiTNode root) {
		if(root==null) {
			return;
		}
		BiTNode p = null;
		Queue<BiTNode> queue = new LinkedList<>();
		queue.offer(root);
		while(queue.size()!=0) {
			p = queue.poll();
			System.out.println(p.data+" ");
			if(p.lchild!=null){
				queue.offer(p.lchild);
			}
			if(p.rchild!=null){
				queue.offer(p.rchild);
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		BiTNode biTNode = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		printTreeLayer(biTNode);
	}
}
