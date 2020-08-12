package com.wd.baseKnowledage.dataStructor.str;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年7月14日 下午6:41:50
* 类说明
*/
public class KMPTest {

	
	public static void getIndex(String str,Integer[] next){
		int i = 1;
		int j = 0;
		next[0]=-1; 
		next[1]=0;   //next下标1的值为0
		while(i<str.length()) {
			/* T[i]表示后缀的单个字符， */
	        /* T[j]表示前缀的单个字符 */
			if(j==0||str.charAt(i)==str.charAt(j)) { //前缀等于后缀
				++i;
				++j;
				next[i] = j-1;
			}else {
				j = next[j];
			}
		}
	}
	
	
	public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k=next[j-1];
            while (k!=-1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                }
                else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }
	
	
	public static void main(String[] args) {
		String str = "abcdex";
//		Integer[] next = new Integer[str.length()];
//		getIndex(str, next);
//		for (Integer integer : next) {
//			System.out.println(integer);			
//		}
		char[] charArray = str.toCharArray();
		int[] nextArray = getNextArray(charArray);
		for (int i : nextArray) {
			System.out.println(i);
		}
	}
	
	
	
}
