package com.wd.baseKnowledage.dataStructor.binaryTree.operator;

import com.wd.baseKnowledage.dataStructor.binaryTree.BiNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年7月19日 下午4:04:10
* 类说明 查找二叉树
*/

public class SearchBiTree {

	
	private BiNode p;
	private BiNode biTrees;  //根节点
	
	public Boolean searchBST(BiNode biTrees,int key,BiNode f,BiNode p){
		if(biTrees==null){
			p = f;
			return false;
		}
		
		if(key ==biTrees.getData()){
			p.setData(biTrees.getData());
			return true;
		}
		
		if(key<biTrees.getData()){
			Boolean result = searchBST(biTrees.getLchild(), key,biTrees, p);
			return result;
		}else {
			Boolean result = searchBST(biTrees.getRchild(), key, biTrees, p);
			return result;			
		}
		
	}
	
	public boolean insertBST(BiNode biTrees,int key) {
		BiNode s = biTrees;
		if(s==null) {
			biTrees = new BiNode();
			biTrees.setData(key);
			return false;
		}
		if(!searchBST(biTrees,key,null,p)) {
			 if(key<biTrees.getData()){
				p.setLchild(s);
			}else{
				p.setRchild(s);
			}
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public BiNode insert(BiNode root,int key){
		BiNode newNode = new BiNode();
		newNode.setData(key);
		if(root==null) {
			return newNode;
		}
		BiNode current = root;
		while(true) {
			if(key<current.getData()) {
				if(current.getLchild()==null){
					current.setLchild(newNode);
					break;
				}else {
					current = current.getLchild();
				}
			}else {
				if(current.getRchild()==null) {
					current.setRchild(newNode);
					break;
				}else{
					current = current.getRchild();
				}
			}
		}
		return root;
	}
	
	
	
	public static void main(String[] args){
		SearchBiTree searchBiTree = new SearchBiTree();
		searchBiTree.testInsertBst();
	}

	
	
	public  void testInsertBst() {
		int[]  a = { 62, 88, 58, 47, 35, 73, 51,99, 37, 93 };
		SearchBiTree searchBiTree = new SearchBiTree();
		for (int i = 0; i < a.length; i++) {
			biTrees = searchBiTree.insert(biTrees, a[i]);
		}
		System.out.println(biTrees);
	}
	
	/**
	 * 测试二叉树顺序查询
	 */
	private static void testSearchBST() {
		SearchBiTree searchBiTree = new SearchBiTree();
		BiNode one = new BiNode();
		one.setData(1);
		BiNode two = new BiNode();
		two.setData(2);
		BiNode three = new BiNode();
		three.setData(3);
		two.setRchild(three);
		one.setRchild(two);
		BiNode p = new BiNode();
		Boolean searchBST = searchBiTree.searchBST(one, 2, null, p);
		System.out.println(searchBST);
	}
	
	
}
