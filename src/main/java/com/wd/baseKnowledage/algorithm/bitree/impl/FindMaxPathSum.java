package com.wd.baseKnowledage.algorithm.bitree.impl;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;
import com.wd.baseKnowledage.algorithm.bitree.IntRef;

/**
 *      寻找二叉树最大路径和 
 *      解题方案：
 *    对于当前遍历到的结点root，假设已经求出在遍历root结点前最大的路径和为max：
1）求出以root.left为起始结点，叶子结点为终结点的最大路径和为maxLeft。
2）同理求出以root.right为起始结点，叶子结点为终结点的最大路径和maxRight。
包含root结点的最长路径可能包含如下三种情况：
1）leftMax=root.val+maxLeft（右子树最大路径和可能为负）。
2）rightMax=root.val+maxRight（左子树最大路径和可能为负）。
3）allMax=root.val+maxLeft+maxRight（左右子树的最大路径和都不为负）。
因此，包含root结点的最大路径和为tmpMax=max（leftMax,rightMax,allMax）。
在求出包含root结点的最大路径后，如果tmpMax＞max，那么更新最大路径和为tmpMax。
 * 
 * @author Administrator
 *
 */
public class FindMaxPathSum {

	public static int max(int a ,int b,int c) {
		int max = a>b?a:b;
		max  = max>c?max:c;
		return max;
	}
	
	public static int findMaxPathrecursive(BiTNode root,IntRef max) {
		if(root==null) {
			return 0;
		}else {
			int sumLeft = findMaxPathrecursive(root.lchild, max);
			int sumRight = findMaxPathrecursive(root.rchild, max);
			
			int maxLeft = sumLeft+root.data;
			System.out.println("maxLeft:"+maxLeft);
			int maxRight = sumRight+root.data;
			System.out.println("maxRight:"+maxRight);
			int maxAll  = root.data+sumLeft+sumRight;
			System.out.println("maxAll:"+maxAll);
			int tmpMax = max(maxLeft, maxRight, maxAll);
			if(tmpMax>max.val) {
				max.val = tmpMax;
			}
			int subMax = sumLeft>sumRight?sumLeft:sumRight;
			return subMax+root.data;
		}
	}
	
	
	public static int findMaxPathSum(BiTNode root) {
		IntRef max = new IntRef();
		max.val = Integer.MIN_VALUE;
		int maxValue = findMaxPathrecursive(root, max);
		System.out.println("起始节点为root节点，叶子节点为结束节点，二叉树最大路径和 :"+maxValue);
		return max.val;
	}
	
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		BiTNode biTNode = ArrayToTree.arraytoTree(array, 0, array.length-1);
		int findMaxPathSum = findMaxPathSum(biTNode);
		System.out.println("二叉树最大路径和 :"+findMaxPathSum);
	}
	
	
	
}
