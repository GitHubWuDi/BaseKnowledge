package com.wd.baseKnowledage.dataStructor.binaryTree;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年7月19日 下午3:59:23
* 类说明   二叉树节点数据结构
*/

public class BiNode {
      private int data; //数据
      private BiNode rchild; //右子节点
      private BiNode lchild; //左子节点
      
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BiNode getRchild() {
		return rchild;
	}
	public void setRchild(BiNode rchild) {
		this.rchild = rchild;
	}
	public BiNode getLchild() {
		return lchild;
	}
	public void setLchild(BiNode lchild) {
		this.lchild = lchild;
	}
      
      
      
}
