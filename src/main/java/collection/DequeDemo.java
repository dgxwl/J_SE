package collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列
 * java.util.Deque
 * 双端队列接口继承自队列接口Queue
 * 
 * 双端队列就是队列两端都可以做进出队操作
 * @author JAVA
 *
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();
		
		deque.offer("one");
		deque.offer("two");
		System.out.println(deque);
		
		deque.offerFirst("three");
		System.out.println(deque);
		
		deque.offerLast("four");
		System.out.println(deque);
		
		String str = deque.poll();
		System.out.println(str);
		System.out.println(deque);
		
		str = deque.pollFirst();
		System.out.println(str);
		System.out.println(deque);
		
		str = deque.pollLast();
		System.out.println(str);
		System.out.println(deque);
	}
}
