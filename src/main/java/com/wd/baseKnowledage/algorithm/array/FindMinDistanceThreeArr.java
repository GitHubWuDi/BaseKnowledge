package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2021年1月6日 上午8:42:17
* 类说明 如何求解最小三元组的距离
*/
public class FindMinDistanceThreeArr {

    /**
     * 求三个元素最小值  
     * @param a
     * @param b
     * @param c
     * @return
     */
	public static int min(int a,int b,int c) {
    	  int min = a<b?a:b;
    	  min=min<c?min:c;
    	  return min;
     }	
	
	/**
	 * 求三个元素最大值
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int max(int a,int b,int c) {
		int max = a<b?b:a;
		max = max<c?c:max;
		return max;
	}
      
	/**
	 * 最小三元组的距离
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int minDistance(int[] a ,int [] b,int [] c) {
		int aLen = a.length;
		int bLen = b.length;
		int cLen = c.length;
		int curDist = 0;
		int min = 0;
		int minDist = Integer.MAX_VALUE;
	    int i = 0; //数组a的下标
	    int j = 0; //数组b的下标
	    int k = 0; //数组c的下标
	    while(true) {
	    	curDist = max(Math.abs(a[i]-b[j]),Math.abs(a[i]-c[k]),Math.abs(b[j]-c[k]));
	    	System.out.println("{"+a[i]+","+b[k]+","+c[k]+"}");
	        if(curDist<minDist) {
	        	minDist =curDist;
	        }
	        //找出当前遍历到三个数组当中的最小值
	        min = min(a[i],b[j],c[k]);
	        if(min == a[i]) {
	        	if(++i>=aLen) {
	        		break;
	        	}
	        }else if(min == b[j]) {
	        	if(++j>=bLen) {
	        		break;
	        	}
	        } else {
	        	if(++k>=cLen) {
	        		break;
	        	}
	        }
	        
	    }
	    return minDist; 
	}
	public static void main(String[] args) {
		int[] a = {3,4,5,6,7,8,9};
		int[] b = {10,12,14,16,17};
		int[] c = {20,21,23,34};
		int minDistance = minDistance(a, b, c);
		System.out.println("最小距离为："+minDistance);
	}
	
}
