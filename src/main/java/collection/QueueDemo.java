package collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列
 * 队列是一个经典的数据结构，用来存放一组元素，但是存取元素
 * 必须遵循先进先出原则.
 * 
 * @author JAVA
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		/*
		 * LinkedList是使用链表结构实现的List,但java还让其实现了Deque接口(继承Queue接口),
		 * 因为链表的特性体现在可以存一组元素，并且首尾增删元素效率高，这正好也满足了队列的特点.
		 */
		Queue<String> queue = new LinkedList<String>();
		/*
		 * boolean offer(String e)
		 * 入队操作，从队尾追加元素
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		queue.offer("five");
		queue.offer("six");
		
		System.out.println(queue);
		/*
		 * E poll()
		 * 出队操作。从队首获取元素，获取后该元素即从队列中被移除。
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * E peek()
		 * 引用队首元素。
		 * 获取后该元素依然在队列中
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * 遍历
		 * 使用迭代器遍历队列，元素不受影响，依然会在队列中。
		 */
		for (String s : queue) {
			System.out.println(s);
		}
		System.out.println(queue);
		
		System.out.println("开始遍历!");
		while (queue.size() > 0) {
			String s = queue.poll();
			System.out.println(s);
		}
		System.out.println("循环结束!");
		System.out.println(queue);
	}
}
