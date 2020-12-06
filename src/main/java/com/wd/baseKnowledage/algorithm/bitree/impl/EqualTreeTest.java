package com.wd.baseKnowledage.algorithm.bitree.impl;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

/**
 * 如何判断两棵二叉树是否相等
 * 解题思路：两棵二叉树相等是指这两棵二叉树有着相同的结构，并且在相同位置上的结点有相同的值。如何判断两棵二叉树是否相等？
 * 如果两棵二叉树root1、root2相等，那么root1与root2结点的值相同，
 * 同时它们的左右孩子也有着相同的结构，并且对应位置上结点的值相等，即root1.data==root2.data，并且root1的左子树与root2的左子树相等，并且root1的右子树与root2的右子树相等。根据这个条件，可以非常容易地写出判断两棵二叉树是否相等的递归算法。
 * @author Administrator
 *
 */
public class EqualTreeTest {

	/**
	 * 判断二叉树1和二叉树2是否是相等的二叉树
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean isEqual(BiTNode root1,BiTNode root2) {
		if(root1==null&&root2==null) {
			return true;
		}
		if(root1==null||root2==null) {
			return false;
		}
		if(root1.data==root2.data){
			return isEqual(root1.lchild,root2.lchild)&& isEqual(root1.rchild,root2.rchild);
		}
		return false;
	}
	
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		BiTNode root1 = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		BiTNode root2 = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		boolean result = isEqual(root1, root2);
		System.out.println("两个二叉树对比结果："+result);
	}
	
	
}
