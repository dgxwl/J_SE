package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 常用的和线程安全相关的API：
 * StringBuilder不是线程安全的，StringBuffer是。
 * 
 * 对于集合而言，常用的ArrayList，LinkedList,HashSet
 * 都不是线程安全的，但是可以使用Collections提供的方法将
 * 它们转化为线程安全的。
 * 
 * 使用队列的时候由于常用的为LinkedList，所以它也不是线程
 * 安全的，在实际开发的时候可以使用双缓冲阻塞队列，它是线程
 * 安全的：BlockingQueue, BlockingDeque
 * BlockQueue, BlockingDeque是接口。
 * 常用实现类：LinkedBlockingDeque
 * 
 * @author JAVA
 *
 */
public class SyncApiDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		/*
		 * 将给定的List集合转换为线程安全的
		 * 线程安全的集合也要注意，不与遍历做互斥，所以
		 * 若多线程并发操作集合时含有遍历操作，那么需要
		 * 自行维护互斥关系。
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);

		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		set = Collections.synchronizedSet(set);
		System.out.println(set);
	}
}
