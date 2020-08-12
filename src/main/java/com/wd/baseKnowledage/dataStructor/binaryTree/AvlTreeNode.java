package com.wd.baseKnowledage.dataStructor.binaryTree;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年7月22日 下午5:44:38
* 类说明  平衡二叉数据结构
*/
public class AvlTreeNode {

	
	private int data;
	private int bf; //平衡因子
	private AvlTreeNode lchild;  //左孩子节点
	private AvlTreeNode rchild; //右孩子节点
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getBf() {
		return bf;
	}
	public void setBf(int bf) {
		this.bf = bf;
	}
	public AvlTreeNode getLchild() {
		return lchild;
	}
	public void setLchild(AvlTreeNode lchild) {
		this.lchild = lchild;
	}
	public AvlTreeNode getRchild() {
		return rchild;
	}
	public void setRchild(AvlTreeNode rchild) {
		this.rchild = rchild;
	}
	
	
}
