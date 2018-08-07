package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为List集合
 * 数组的工具类：Arrays提供了将数组转为List集合的方法
 * 
 * @author JAVA
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "four"};
		
		List<String> list = Arrays.asList(array);
		System.out.println(list.size());
		System.out.println(list);
		/*
		 * 若该集合是数组转换的，那么操作该集合元素
		 * 就等于操作原数组对应元素
		 */
		list.set(1, "2");
		System.out.println(list);
		
		for (String str : array) {
			System.out.println(str);
		}
		
		/*
		 * 不可以增删元素。因为数组是定长的。
		 * 由于Arrays.asList()返回的是Arrays内部实现的ArrayList,且未
		 * 重写add()和remove()方法,因此调用的是其父类AbstractList中对应的
		 * 方法,直接抛出UnsupportedOperationException
		 */
//		list.add("five");
//		System.out.println(list);
		
		/*
		 * 使用asList()将数组转换为List时, 原数组元素类型必须为包装类;
		 * 如果原为基本数据类型数组int[], 转换成的将会是一个长度为1的List, 
		 * 其泛型为int[]
		 */
//		int[] a = new int[] {1, 2, 3, 4, 5};
		Integer[] a = new Integer[] {1, 2, 3, 4, 5};
		System.out.println(Arrays.asList(a));
		
		/*
		 * 所有的集合都支持一个参数为Collection类型的构造方法，
		 * 该构造方法的意义在于创建当前集合的同时包含给定集合中的所有元素.
		 */
		List<String> list1 = new ArrayList<String>(list);
		System.out.println(list1);
		list1.add("five");
		System.out.println(list1);
	}
}
