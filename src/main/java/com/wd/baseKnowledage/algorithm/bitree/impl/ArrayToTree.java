package com.wd.baseKnowledage.algorithm.bitree.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月3日 上午9:09:59
* 类说明:如何把一个有序的整数数组放到二叉树中
* 解题思路：取数组的中间元素作为根结点，将数组分成左右两部分，对数组的两部分用递归的方法分别构建左右子树
*/

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

public class ArrayToTree {

	/**
	 * 方法体：把有序数组转换为二叉树
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static BiTNode arraytoTree(int[] arr,int start,int end) {
			BiTNode root = null;
			if(end>=start) {
				root = new BiTNode();
				int mid = (start+end+1)/2;
				root.data = arr[mid];
				root.lchild = arraytoTree(arr, start, mid-1);
				root.rchild = arraytoTree(arr, mid+1, end);
			}else {
				root = null;
			}
			return root;
	}
	
	
	/*用中序遍历的方式打印出二叉树结点的内容*/
	public static void printTreeMidOrder(BiTNode root) {
		if(root==null) return;
		if(root.lchild!=null) {
			printTreeMidOrder(root.lchild);
		}
		System.out.println(root.data+" ");
		if(root.rchild!=null) {
			printTreeMidOrder(root.rchild);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		BiTNode arraytoTree = arraytoTree(arr, 0, arr.length-1);
		printTreeMidOrder(arraytoTree);
	}
	
	
	
}
