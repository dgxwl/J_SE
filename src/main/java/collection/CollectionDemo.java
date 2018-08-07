package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java集合框架
 * 集合：java.util.Collection是所有集合的顶级接口。
 * 集合用来存放一组元素，功能上和数组一致。但是提供了操作
 * 元素的相关方法，使用便捷，并且实现了计算机中的诸多经典
 * 数据结构。
 * 
 * Collection派生了两个常用的子接口：
 * java.util.List：元素可重复集合，且有序.
 * java.util.Set：元素不可重复集合.
 * 元素是否重复的判断标准是元素自身equals()比较的结果.
 * @author JAVA
 *
 */
public class CollectionDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * boolean add(E e)
		 * 将给定元素添加到集合中
		 * 返回值为元素是否成功添加(List集合总是返回
		 * true的，但是Set集合由于不允许存放重复元素
		 * 所以会有重复元素添加不成功的情况)
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		
		System.out.println(c);
		
		int size = c.size();
		System.out.println("size:" + size);
		
		/*
		 * boolean isEmpty
		 * 判断是否为空集(集合不含有任何元素)
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("isEmpty：" + isEmpty);
		
		/*
		 * void clear()
		 * 清空集合
		 */
		c.clear();
		System.out.println("清空完毕!");
		
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(c.isEmpty());
	}
}
