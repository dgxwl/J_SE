package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List：可重复集合且有序
 * 常用实现类：java.util.ArrayList，java.util.LinkedList
 * ArrayList内部使用数组实现，查询更快
 * LinkedList内部使用链表实现，增删元素更快，尤其首尾增删。
 * 
 * List由于是有序集合，所以提供了一套根据下标操作元素的方法
 * 
 * @author JAVA
 *
 */
public class List_get_set {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		/*
		 * E get(int index)
		 * 获取给定下标对应的元素
		 */
		//获取第二个元素
		String str = list.get(1);
		System.out.println(str);
		
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * [one, 2, three, four]
		 * 
		 * E set(int index, E e)
		 * 将给定元素设置到指定位置，返回值为原位置对应的元素。所以是替换元素操作.
		 */
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old: " + old);
	}
}
