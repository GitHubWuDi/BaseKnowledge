package com.wd.baseKnowledage.algorithm.bitree;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月14日 上午8:51:01
* 类说明
*/
public class TriedNode {

	public final int CHAR_COUNT=11;
	public boolean isLeaf;
	public String url;
	public TriedNode[] child;
	
	public TriedNode() {
		this.isLeaf = false;
		this.url = null;
	    this.child = new TriedNode[CHAR_COUNT];
	    for (int i = 0; i < CHAR_COUNT; i++) {
	    	child[i] = null;
		}
	}
}
