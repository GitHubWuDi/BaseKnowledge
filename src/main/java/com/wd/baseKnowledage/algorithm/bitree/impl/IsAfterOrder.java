package com.wd.baseKnowledage.algorithm.bitree.impl;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月8日 上午8:47:34
* 题目说明：如何判断一个数组是否是二元查找后序遍历序列
* 二元查找树的特点：对于任意一个结点，它的左子树上所有结点的值都小于这个结点的值，
* 它的右子树上所有结点的值都大于这个结点的值。根据这个特点及二元查找树后序遍历的特点可以看出，
* 这个序列的最后一个元素一定是树的根结点（上图中的结点4），然后在数组中找到第一个大于根结点4的值5，那么结点5之前的序列（1,3,2）对应的结点一定位于结点4的左子树上，
* 结点5（包含这个结点）后面的序列一定位于结点4的右子树上（也就是说，结点5后面的所有值都应该大于或等于4）。
* 算法复杂度：
* 这种方法与二叉树的中序遍历有着相同的时间复杂度O（N）。此外，这种方法只用了两个额外的变量pHead与pEnd来记录双向链表的首尾结点，因此，空间复杂度为O（1）。
*/
public class IsAfterOrder {

	
	/**
	 * 输入参数：arr数组
	 * 返回值：true or false
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isAfterOrder(int[] arr,int start,int end) {
		if(arr==null) {
			return false;
		}
		//数组的最后一个结点必是后序遍历的根结点
		int root  = arr[end];
		int i,j;
		//找到第一个大于root的值，那么前面所有的结点都位于root的左子树上面
		for (i = start; i < end; i++) {
			if(arr[i]>root) {
				break;
			}
		}
		//如果数组是后序遍历的序列，那么i开始的所有值都应该大于根结点的root的值
		for (j =i ; j < end; j++) {
			if(arr[j]<root) {
				return false;
			}
		}
		
		boolean leftIsAfterOrder = true;
		boolean rightIsAfterOrder = true;
		//判断小于root的值得序列是否是某一二元查找树的后续遍历
        if(i>start) {
        	leftIsAfterOrder = isAfterOrder(arr,start,i-1);
		}
      //判断大于于root的值得序列是否是某一二元查找树的后续遍历
        if(j<end) {
        	rightIsAfterOrder = isAfterOrder(arr, i, end);
        }
        return leftIsAfterOrder&&rightIsAfterOrder;
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,3,2,5,7,6,4};
		boolean afterOrder = isAfterOrder(arr, 0, arr.length-1);
		if(afterOrder) {
			System.out.println("arr[]是二元查找树的后序遍历序列");
		}else {
			System.out.println("arr[]不是二元查找树的后序遍历序列");
		}
	}
	
	
	
}
