package com.wd.baseKnowledage.algorithm.bitree.impl;

import java.util.LinkedList;
import java.util.Queue;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月11日 上午8:43:32
* 题目说明：如何对二叉树进行镜像反转
* 要实现二叉树的镜像反转，只需交换二叉树中所有结点的左右孩子即可。
* 由于对所有的结点都做了同样的操作，因此，可以用递归的方法来实现。由于需要调用printTreeLayer层序打印二叉树，这种方法中使用了队列来实现
*/
public class ReverseTree {

	public static void reverseTree(BiTNode root) {
		if(root==null) {
			return;
		}
		reverseTree(root.lchild);
		reverseTree(root.rchild);
		BiTNode tmpBiTNode = new BiTNode();
		tmpBiTNode = root.lchild;
		root.lchild = root.rchild;
		root.rchild=tmpBiTNode;
	}
	/**
	 * 二叉树层序遍历，使用队列进行遍历
	 * @param root
	 */
	public static void printTreeLayer(BiTNode root) {
		if(root==null) {
			return;
		}
		BiTNode p;
		Queue<BiTNode> queue = new LinkedList<>();
		queue.offer(root);
		while(queue.size()>0) {
			p = queue.poll();
			System.out.println(p.data+" ");
			if(p.lchild!=null) {
				queue.offer(p.lchild);
			}
			if(p.rchild!=null) {
				queue.offer(p.rchild);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		BiTNode arraytoTree = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		System.out.println("二叉树层序遍历结果：");
		printTreeLayer(arraytoTree);
		reverseTree(arraytoTree);
		System.out.println("反转二叉树层序遍历结果：");
		printTreeLayer(arraytoTree);
		
	}
	
	
}
