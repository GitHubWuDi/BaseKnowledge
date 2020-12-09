package com.wd.baseKnowledage.algorithm.bitree.impl;

import java.util.Stack;

import com.wd.baseKnowledage.algorithm.bitree.BiTNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月9日 上午9:00:17
* 类说明：如何找出排序二叉树上任意两个结点的最近共同父结点
* 方法一：路径对比法
* 对于一棵二叉树的两个结点，如果知道了从根结点到这两个结点的路径，就可以很容易地找出它们最近的公共父结点。因此，可以首先分别找出从根结点到这两个结点的路径（如上图中从根结点到结点1的路径为6→3→2→1，从根结点到结点5的路径为6→3→5）；
* 然后遍历这两条路径，只要是相等的结点都是它们的父结点，找到最后一个相等的结点即为离它们最近的共同父结点，在这个例子中，结点 3 就是它们共同的父结点。为了便于理解，这里仍然使用3.2节中构造的二叉树的方法。
* 时间复杂度O（N）
* 方法二：后序遍历法
* 查找结点 node1 与结点 node2的最近共同父结点可以转换为找到一个结点node，使得node1与node2分别位于结点node的左子树或右子树中。
* 时间复杂度：O（N）
*/
public class FindParentNode {

	
	/**
	 * 获取二叉树从根结点到node结点的路径
	 * @param root
	 * @param node
	 * @param s
	 * @return
	 */
	private static boolean getPathFromRoot(BiTNode root,BiTNode node,Stack<BiTNode> s) {
		if(root==null) {
			return false;
		}
		if(root==node) {
			s.push(root);
			return true;
		}
		if(getPathFromRoot(root.lchild, node, s) || getPathFromRoot(root.rchild, node, s)){
			s.push(root);
			return true;
		}
		return false;
	}
	/**
	 * 通过路径进行对应的查询工作
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static BiTNode findParentNode1(BiTNode root,BiTNode node1,BiTNode node2){
		BiTNode commonBitNode = null;
		Stack<BiTNode> stack1 = new Stack<>();
		Stack<BiTNode> stack2 = new Stack<>();
		getPathFromRoot(root, node1, stack1);
		getPathFromRoot(root, node2, stack2);
		while(stack1.peek()==stack2.peek()) {
			commonBitNode = stack1.peek();
			stack1.pop();
			stack2.pop();
		}
		return commonBitNode;
	}
	public static BiTNode findParentNode2(BiTNode root,BiTNode node1,BiTNode node2){
		if(null==root||root==node1||root==node2) {
			return root;
		}
		BiTNode lchild = findParentNode2(root.lchild, node1, node2);
		BiTNode rchild = findParentNode2(root.rchild, node1, node2);
		if(lchild==null) {
			return rchild;
		}else if(rchild==null) {
			return lchild;
		}else {
			return root;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		BiTNode root = ArrayToTree.arraytoTree(arr, 0, arr.length-1);
		BiTNode node1 = root.lchild.lchild.lchild;
		BiTNode node2 = root.lchild.rchild;
		//BiTNode res = findParentNode1(root, node1, node2);
		BiTNode res = findParentNode2(root, node1, node2);
		if(res!=null) {
			System.out.println(node1.data+"和"+node2.data+"的公共结点为"+res.data);
		}else {
			System.out.println(node1.data+"和"+node2.data+"没有公共结点");
		}
	}
	
	
	
	
	
}
