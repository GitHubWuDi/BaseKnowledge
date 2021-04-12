package com.wd.baseKnowledage.algorithm.math;

/**
 * 如何判断一个数是否是2的n次方
 * @author Administrator
 *
 */
public class Power2 {

	
	/**
	 * 通过移位法判断一个数是否是2的n次方
	 * @param n
	 * 时间复杂度：O(logn)
	 * @return
	 */
	public static boolean isPower1(int n) {
		if(n<1) {
			return false;
		}
		int i = 1;
		while(i<=n) {
			if(i==n) {
				return true;
			}
			i<<=1;
		}
		return false;
	}
	
	/**
	 * 通过与的操作法
	 * 判断标准：因此，判断一个数是否为2的n次方可以转换为这个数对应的二进制表示中是否只有一位为1。如果一个数的二进制表示中只有一位是1，
	 * 例如num=00010000，那么num-1的二进制表示为num-1=00001111。由于num与num-1二进制表示中每一位都不相同，因此num&（num-1）的运算结果为0。
	 * @param n
	 * @return
	 */
	public static boolean isPower2(int n) {
		if(n<1) {
			return false;
		}
		int m = n&(n-1);
		return m==0;
	}
	
	
	
	public static void main(String[] args) {
		if(isPower2(8)) {
			System.out.println("8能表示2的n次方");
		}
		if(!isPower2(9)) {
			System.out.println("9不能表示2的n次方");
		}
	}
	
	
	
}
