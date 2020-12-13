package com.wd.baseKnowledage.algorithm.bitree.impl;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

/**
 * 题目：如何在二叉树中找出第一个大于中间值的节点
 * 解题方案:首先需要找出二叉排序树中的最大值与最小值。由于二叉排序树的特点是，对于任意一个结点，它的左子树上所有结点的值都小于这个结点的值，它的右子树上所有结点的值都大于这个结点的值。因此，在二叉排序树中，最小值一定是最左下的结点，最大值一定是最右下的结点。
 * 根据最大值与最小值很容易就可以求出f的值。接下来对二叉树进行中序遍历。如果当前结点的值小于f，那么在这个结点的右子树中接着遍历，否则遍历这个结点的左子树。
 * @author Administrator
 *
 */
public class FindMidNode {

	
	/**
	 * 获得最小的值的节点
	 * @param root
	 * @return
	 */
	private  static BiTNode getMinNode(BiTNode root) {
		if(root==null) {
		     return null;
		}
		while(root.lchild!=null) {
			root = root.lchild;
		}
		return root;
	}
	
	
	/**
	 *     获得最大值的节点
	 * @param root
	 * @return
	 */
	private static BiTNode getMaxNode(BiTNode root) {
		if(root==null) {
			return root;
		}
		while(root.rchild!=null) {
			root = root.rchild;
		}
		return root;
	}
	
	
	/**
	 * 在二叉树中找出第一个大于中间值的节点
	 * @param root
	 * @return
	 */
	private static BiTNode getMidNode(BiTNode root) {
		BiTNode minNode = getMinNode(root);
		BiTNode maxNode = getMaxNode(root);
		int mid = (minNode.data+maxNode.data)/2;
		BiTNode result = null;
		while(root!=null) {
			if(root.data<=mid) {
				root = root.rchild;
			}else {
				result = root;
				root = root.lchild;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		BiTNode root = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		BiTNode midNode = getMidNode(root);
		System.out.println("二叉树中找出第一个大于中间值的节点是："+midNode.data);
	}
	
	
	
	
}
