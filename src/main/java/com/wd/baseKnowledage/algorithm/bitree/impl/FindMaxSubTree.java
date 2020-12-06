package com.wd.baseKnowledage.algorithm.bitree.impl;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

/**
 * 如何求二叉树的最大子树和
 * 解题思路：要求一棵二叉树的最大子树和，最容易想到的办法就是针对每棵子树，求出这棵子树中所有结点的和，然后从中找出最大值。
 * 恰好二叉树的后序遍历就能做到这一点。在对二叉树进行后序遍历的过程中，如果当前遍历的结点的值与其左右子树和的值相加的结果大于最大值，则更新最大值
 * 这种方法与二叉树的后序遍历有相同的时间复杂度，即为O（N）。其中，N为二叉树的结点个数。
 * @author Administrator
 *
 */
public class FindMaxSubTree {

	private static Integer maxSum = Integer.MIN_VALUE;
	
	/**
	   * 求最大子树
	   * 输入参数：root（根节点）
	 * maxRoot 最大子树的根节点
	 * @param root
	 * @param maxRoot
	 * @return
	 */
	public static Integer findMaxSubTree(BiTNode root,BiTNode maxRoot) {
		if(root==null) {
			return 0;
		}
		int lmax = findMaxSubTree(root.lchild,maxRoot);
		int rmax = findMaxSubTree(root.rchild, maxRoot);
		int sum  = lmax+rmax+root.data;
		if(sum>maxSum) {
			maxSum = sum;
			maxRoot.data = root.data;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		BiTNode biTNode = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		BiTNode  maxRoot = new BiTNode();
		Integer findMaxSubTree = findMaxSubTree(biTNode, maxRoot);
		System.out.println("最大子树和是："+findMaxSubTree);
		System.out.println("最大子树的根节点是："+maxRoot.data);
	}
	
}
