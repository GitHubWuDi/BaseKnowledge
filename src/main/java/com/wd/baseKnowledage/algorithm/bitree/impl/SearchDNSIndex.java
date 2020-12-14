package com.wd.baseKnowledage.algorithm.bitree.impl;

import com.wd.baseKnowledage.algorithm.bitree.TriedNode;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月14日 上午8:59:07
* 类说明 如何实现反向DNS查找缓存
* 要想实现反向DNS查找缓存，主要需要完成如下功能：
1）将IP地址添加到缓存中的URL映射。
2）根据给定IP地址查找对应的URL。
对于本题的这种问题，常见的一种解决方案是使用哈希法（使用Hashmap来存储IP地址与 URL 之间的映射关系），由于这种方法相对比较简单，这里就不做详细的介绍了。下面重点介绍另外一种方法：Trie树。这种方法的主要优点如下：
1）使用Trie树，在最坏的情况下的时间复杂度为O（1） ，而哈希方法在平均情况下的时间复杂度为O（1）；
2）Trie树可以实现前缀搜索（对于有相同前缀的IP地址，可以寻找所有的URL）。
*/
public class SearchDNSIndex {

	private TriedNode root = new TriedNode();
	/**
	 * 获得字符的索引位置
	 * @param c
	 * @return
	 */
	public int getIndexFromChar(char c) {
		return (c=='.')?10:(c-'0');
	}
	
	/**
	 * 根据字符串的位置获得对应的字符
	 * @param i
	 * @return
	 */
	public char getCharFromIndex(int i) {
		return (i==10)?'.':(char)('0'+i);
	}
	
	
	public void insert(String ip,String url) {
		int len = ip.length();
		TriedNode pCrawl  = root;
		int level;
		for (level = 0; level < len; level++) {
			int index = getIndexFromChar(ip.charAt(level));
			if(pCrawl.child[index]==null) {
				pCrawl.child[index] = new TriedNode();
			}
			pCrawl = pCrawl.child[index];
		}
		pCrawl.isLeaf = true;
		pCrawl.url = url;
	}
	
	public String searchDNSCache(String ip) {
		int len = ip.length();
		TriedNode pCrawl  = root;
		int level;
		for (level = 0; level < len; level++) {
			int index = getIndexFromChar(ip.charAt(level));
			if(pCrawl.child[index]==null) {
				return null;
			}
			pCrawl = pCrawl.child[index];
		}
		if(pCrawl!=null&&pCrawl.isLeaf) {
			return pCrawl.url;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		String[] ipAddr = {"192.168.120.103","192.168.120.104","192.168.120.105","192.168.120.106"};
		String[] url = {"www.baidu.com","www.super.com","www.wudi.com","www.keke.com"};
		int n  = ipAddr.length;
		SearchDNSIndex searchDNSIndex = new SearchDNSIndex();
		for (int i = 0; i <n; i++) {
			searchDNSIndex.insert(ipAddr[i], url[i]);
		}
		String ip = "192.168.120.103";
		String searchDNSCache = searchDNSIndex.searchDNSCache(ip);
		if(searchDNSCache!=null){
			System.out.println("找到了IP对应URL:"+searchDNSCache);
		}
	}
	
	
}
