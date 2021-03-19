package com.wd.baseKnowledage.algorithm.str;

/**
 * 如何对字符串进行反转
 * @author Administrator
 *
 */
public class ReverseStr {

	/**
	 * 反转字符串
	 * @param str
	 * @return
	 */
	public static String reverseStr(String str) {
		char[] ch = str.toCharArray();
		int length = ch.length;
		char tmp;
		for (int i = 0,j = length-1; i < j; i++,j--) {
			tmp = ch[i];
			ch[i] = ch[j];
			ch[j]=tmp;
		}
		return new String(ch);
	}
	
	
	public static String reverseStrAbs(String str) {
		char[] ch = str.toCharArray();
		int length = ch.length;
		for (int i = 0,j = length-1; i < j; i++,j--) {
			ch[i] = (char)(ch[i]^ch[j]);
			ch[j] = (char)(ch[i]^ch[j]);
			ch[i] = (char)(ch[i]^ch[j]);
		}
		return new String(ch);
	}
	
	
	
	public static void main(String[] args) {
		String content = "adffewfweffgg";
		String reverseStr = reverseStrAbs(content);
		System.out.println(reverseStr);
	}
	
}
