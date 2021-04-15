package com.wd.baseKnowledage.algorithm.math;

/**
 * 如何不用加减乘除运算实现加法运算
 * @author Administrator
 *
 */
public class Add {

	
	/**
	 * 1）二进制各个位相加而不考虑进位。在不考虑进位的时候加法操作可以用异或操作代替。
       2）计算进位，由于只有1+1才会产生进位，因此，进位的计算可以用“与”操作代替。进位的计算方法为：先做与运算，再把运算结果左移一位。
       3）不断对1）、2）两步得到的结果相加，直到进位为0时为止。
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int add(int n1,int n2) {
		int sum = 0; //保存不进位结果
		int carry = 0; //保存进位值
		do {
			sum=n1^n2; //异或代替不进位相加
			carry = (n1&n2)<<1; //与操作代理计算进位值
			n1 = sum;
			n2 = carry;
		}while(carry!=0);   //判断进位值是否为0
		return sum;
	}
	
	/**
	 * 由于减去一个数等于加上这个数的相反数，即-n=～（n-1）=～n+1，
	 * 因此 a-b=a+（-b）=a+（～b）+1，可以利用上面已经实现的加法操作来实现减法操作。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sub(int a,int b) {
		return add(a,add(~b,1));
	}
	
	
	public static void main(String[] args) {
		System.out.println(sub(1000,200));
	}
}
