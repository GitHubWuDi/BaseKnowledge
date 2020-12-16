package com.wd.baseKnowledage.algorithm.array;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年12月16日 上午8:54:28
* 类说明 如何找到数组当中的最大值和最小值
* 分治法就是将一个规模为n的、难以直接解决的大问题，分割为k个规模较小的子问题，采取各个击破、分而治之的策略得到各个子问题的解，然后将各个子问题的解进行合并，从而得到原问题的解的一种方法。
本题中，当采用分治法求解时，就是将数组两两一对分组，如果数组元素个数为奇数个，就把最后一个元素单独分为一组，然后分别对每一组中相邻的两个元素进行比较，把二者中值小的数放在数组的左边，值大的数放在数组右边，只需要比较 n/2 次就可以将数组分组完成。
然后可以得出结论：最小值一定在每一组的左边部分，最大值一定在每一组的右边部分，接着只需要在每一组的左边部分找最小值，右边部分找最大值，查找分别需要比较n/2-1次和n/2-1次。
因此，总共比较的次数大约为n/2*3=3n/2-2次。
*/
public class FindMaxAndMinValue {

	private int max;
	private int min;
	
	public int getMax() {
		return max;
	}
	public int getMin() {
		return min;
	}
	
	public void getMaxAndMin(int[] arr) {
		if(arr==null) {
			System.out.println("参数不合法");
			return;
		}
		int i = 0;
		int len = arr.length;
		max = arr[0];
		min = arr[0];
		//两两分组，把较小的数放到左半部分，较大的数放在右半部分
		for (i = 0; i < len-1; i+=2) {
			if(arr[i]>arr[i+1]) {
				int tmp = arr[i];
				arr[i]= arr[i+1];
				arr[i+1] = tmp;
			}
		}
		min = arr[0];
		for (i = 2; i < len; i+=2) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		//在各个分组的右半部分找最大值
		max = arr[1];
		for (i = 3; i < len; i+=2) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		if(len%2==1) {
			if(max<arr[len-1]) {
				max = arr[len-1];
			}
			if(min>arr[len-1]) {
				min = arr[len-1];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,19,40,4,7,1};
		FindMaxAndMinValue maxAndMinValue = new FindMaxAndMinValue();
		maxAndMinValue.getMaxAndMin(array);
		System.out.println("最大值："+maxAndMinValue.getMax());
		System.out.println("最小值："+maxAndMinValue.getMin());
	}
	
}
