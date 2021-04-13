package com.wd.baseKnowledage.algorithm.math;

/**
 * 如何不使用除法操作符实现两个正整数的除法
 * @author Administrator
 *
 */
public class Divide {

	/**
	 * 使被除数不断减去除数，直到相减的结果小于除数为止。此时，商就为相减的次数，余数为最后相减的差。
	 * O（m/n）
	 * @param m
	 * @param n
	 */
	public static void divide1(int m,int n) {
		System.out.println(m+"除以"+n);
		int multi;
		int result = 0;
		while(m>=n) {
			multi = 1;
			//multi*n>m/2
			while(multi*n<=m>>1) {
				multi<<=1;
			}
			result+=multi;
			m-=multi*n;
		}
		
		System.out.println("商为："+result+"余数："+m);
	}
	
	/**
	 * 以2的指数进行递增（取2的指数的原因是，2的指数操作可以通过移位操作来实现，有更高的效率）
	 * ，计算4*1,4*2,4*4,4*8，由于4*8＞17，然后接着对17-4×4=1进入下一次循环用相同的方法进行计算。
	 * @param m
	 * @param n
	 */
	public static void divide2(int m,int n) {
		System.out.println(m+"除以"+n);
		int res = 0;
		int remain = m;
		while(m>=n) {
			m = m-n;
			res++;
		}
		remain = m;
		System.out.println("商为："+res+"余数："+remain);
	}
	
	
	
	public static void main(String[] args) {
		divide1(18, 7);
		divide2(18, 7);
	}
	
	
	
}
