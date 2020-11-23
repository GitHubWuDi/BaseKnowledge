package com.wd.baseKnowledage.algorithm.StackAndQueue.stack;

import java.util.Stack;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月23日 下午6:38:08
* 类说明 如何根据入栈序列判断可能的出栈序列
* 1）把push序列依次入栈，直到栈顶元素等于pop序列的第一个元素，然后栈顶元素出栈，pop序列移动到第二个元素。
  2）如果栈顶继续等于pop序列现在的元素，则继续出栈并pop后移；否则对push序列继续入栈。
  3）如果push序列已经全部入栈，但是pop序列未全部遍历，而且栈顶元素不等于当前pop元素，那么这个序列不是一个可能的出栈序列。如果栈为空，而且pop序列也全部被遍历过，则说明这是一个可能的pop序列。下图给出一个合理的pop序列的判断过程。
  算法性能： 这种方法在处理一个合理的pop序列的时候需要操作的次数最多，即把push序列进行一次压栈和出栈操作，操作次数为 2N。因此，时间复杂度为 O（N）。此外，这种方法使用了额外的栈空间，因此，空间复杂度为O（N）。
*/
public class JudgePopOrderByPushOrder {

	/**
	 * 判断栈序列判断可能的出栈序列
	 * @param push
	 * @param pop
	 * @return
	 */
	public static boolean isPopSerial(String push,String pop) {
		if(push==null || pop==null) {
			return false;
		}
		int pushLen = push.length();
		int popLen = pop.length();
		if(pushLen!=popLen) {  //push与pop长度必须相同
			return false;
		}
		int pushIndex = 0;
		int popIndex = 0;
		Stack<Character> stack = new Stack<>();
		while(pushIndex<popLen) {
			stack.push(push.charAt(pushIndex));
			pushIndex++;
			while(!stack.empty()&&stack.peek()==pop.charAt(popIndex)){
				stack.pop();
				popIndex++;
			}
			
		}
		return stack.empty()&&popIndex==popLen;
	}
	
	
	public static void main(String[] args) {
		String push = "12345";
		String pop = "32549";
		if(isPopSerial(push, pop)) {
			System.out.println(pop+"是"+push+"的一个pop子序列！");
		}else {
			System.out.println(pop+"不是"+push+"的一个pop子序列！");
		}
	}
	
	
}
