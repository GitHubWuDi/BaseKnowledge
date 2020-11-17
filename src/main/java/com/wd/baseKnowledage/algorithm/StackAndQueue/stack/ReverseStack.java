package com.wd.baseKnowledage.algorithm.StackAndQueue.stack;

import java.util.Stack;

/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2020年11月17日 下午4:44:38
* 类说明     反转Stack:主要思路：把不包含该栈顶元素的子栈的栈底的元素移动到子栈的栈顶，然后把栈顶的元素与子栈栈顶的元素（其实就是与栈顶相邻的元素）进行交换。
* 递归定义和递归终止条件。经过分析后，很容易得到该问题的递归定义和递归终止条件。递归定义：将当前栈的最底元素移到栈顶，其他元素顺次下移一位，然后对不包含栈顶元素的子栈进行同样的操作。终止条件：递归下去，直到栈为空。
* s
*/
public class ReverseStack{

	/**
	 * 将栈的底层数据转移到头部
	 * @param s
	 */
	public void moveBottomTop(Stack<Integer> s) {
		if(s.empty()) {
			return ;
		}else {
			Integer top1 = s.peek(); //栈顶元素
			s.pop();
			if(!s.empty()) {
				moveBottomTop(s);
				Integer top2 = s.peek();//此时栈顶元素
				if(top1>top2) {   //引申：给栈进行排序
					s.pop();
					s.push(top1);
					s.push(top2);
                    return ;					
				}
			}else {
				s.push(top1);
			}
		}
	}
	
	public void reverseStack(Stack<Integer> s) {
		if(s.empty()) {
			return;
		}else {
			moveBottomTop(s);
			Integer top1 = s.peek();
			s.pop();
			reverseStack(s);
			s.push(top1);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < 5; i++) {
			s.push(i);
		}
		System.out.println("反转之前："+s);
		ReverseStack reverseStack = new ReverseStack();
		reverseStack.reverseStack(s);
		System.out.println("反转之后："+s);
	}
	
}
