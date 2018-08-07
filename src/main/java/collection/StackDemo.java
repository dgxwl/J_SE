package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 栈用来存放一组元素，存取元素必须遵循先进后出原则
 * 
 * 通常使用栈可以实现“后退”，“前进”功能。（比如浏览器中的
 * 后退，前进功能就是栈实现的）
 * @author JAVA
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		//入栈操作
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		
		System.out.println(stack);
		//出栈操作
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack);
		
		for (String s : stack) {
			System.out.println(s);
		}
		
		while (stack.size() > 0) {
			String s = stack.pop();
			System.out.println(s);
		}
		System.out.println(stack);
	}
}
