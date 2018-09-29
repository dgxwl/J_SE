package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了一对重载的add(), remove()方法
 * @author JAVA
 *
 */
public class List_add_remove {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		/*
		 * [one, two, three, four]
		 * 
		 * [one, two, 2, three, four]
		 * 
		 * void add(int index, E element)
		 * 将给定元素插入到指定位置
		 */
		list.add(2, "2");
		System.out.println(list);
		
		/*
		 * [one, two, 2, three, four]
		 * 
		 * [one, 2, three, four]
		 * E remove(int index)
		 * 删除并返回给定位置处所对应的元素
		 */
		String old = list.remove(1);
		System.out.println(list);
		System.out.println("old: " + old);
	}
}
