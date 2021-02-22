package com.wd.baseKnowledage.algorithm.array;

/**
 * 如何求集合当中的所有子集
 * @author Administrator
 *
 *具体步骤如下。
1）构造一个和集合一样大小的数组A，分别与集合中的某个元素对应。数组A中的元素只有两种状态：“1”和“0”，分别代表每次子集输出中集合中对应元素是否要输出，这样数组A可以看作是原集合的一个标记位图。
2）数组A模拟整数“加1”的操作，每执行“加1”操作之后，就将原集合中所有与数组A中值为“1”的相对应的元素输出。
设原集合为＜a,b,c,d＞，数组A的某次“加1”后的状态为[1,0,1,1]，则本次输出的子集为＜a,c,d＞。使用非递归的思想，如果有一个数组，大小为 n，那么就使用 n 位的二进制，如果对应的位为1，那么就输出这个位，如果对应的位为0，那么就不输出这个位。
 */
public class FindChildrenSet {
   
	public static void getAllSubSet(char[] array,int[] mask,int c) {
		int length = array.length;
		int i;
		if(length==c) {
			System.out.print("{");
			for (i = 0; i < length; i++) {
				if(mask[i]==1) {
					System.out.print(array[i]+" ");
				}
			}
			System.out.println("}");
		}else {
			mask[c] = 1;
			getAllSubSet(array,mask,c+1);
			mask[c] = 0;
			getAllSubSet(array,mask,c+1);
		}
	}
	
	public static void main(String[] args) {
		char array[] = {'a','b','c'};
		int[] mask = {0,0,0};
		getAllSubSet(array, mask, 0);
	}
	
}
