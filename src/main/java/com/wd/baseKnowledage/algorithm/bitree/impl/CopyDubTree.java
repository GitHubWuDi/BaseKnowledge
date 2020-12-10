package com.wd.baseKnowledage.algorithm.bitree.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月10日 上午8:35:53
* 题目：如何复制二叉树
* 用给定的二叉树的根结点root来构造新的二叉树的方法：首先创建新的结点dupTree，然后根据root结点来构造dupTree结点（dupTree.data=root.data），最后分别用root的左右子树来构造 dupTree 的左右子树。
* 时间复杂度：O(N)
*/

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

public class CopyDubTree {

	
	/**
	 * 复制一个二叉树
	 * @param root
	 * @return
	 */
	public static BiTNode createDubTree(BiTNode root) {
		if(root==null) {
			return null;
		}
		BiTNode bitNode = new BiTNode();
		bitNode.data = root.data;
		bitNode.lchild = createDubTree(root.lchild);
		bitNode.rchild = createDubTree(root.rchild);
		return bitNode;
	}
	
	/**
	 * 中序打印二叉树
	 * @param root
	 */
	public static void printMidOrder(BiTNode root) {
		if(root==null) {
			return;
		}
		if(root.lchild!=null) {
			printMidOrder(root.lchild);
		}
		System.out.println(root.data+" ");
		if(root.rchild!=null) {
			printMidOrder(root.rchild);
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		BiTNode arraytoTree = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		System.out.println("原二叉树中序排列：");
		printMidOrder(arraytoTree);
		BiTNode createDubTree = createDubTree(arraytoTree);
		System.out.println("复制打印原二叉树中序排列：");
		printMidOrder(createDubTree);
	}
	
	
}
