package com.wd.baseKnowledage.algorithm.bitree.impl;

import java.util.Vector;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月10日 上午8:55:25
* 类说明：如何在二叉树中找出与输入整数相等的所有路径
*/
public class FindTreeRoad {

	
	public static void findRoad(BiTNode root,Integer num,Integer sum,Vector<Integer> v) {
		sum+=root.data;
		v.add(root.data);
		if(root.lchild==null&&root.rchild==null&&sum==num){
			for (Integer s : v) {
				System.out.println(s+" ");
				System.out.println();
			}
		}
		
		if(root.lchild!=null) {
			findRoad(root.lchild, num, sum, v);
		}
		
		if(root.rchild!=null) {
			findRoad(root.rchild, num, sum, v);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		BiTNode root = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		Vector<Integer> v  = new Vector<>();
		findRoad(root, 12, 0, v);
	}
	
	
}
