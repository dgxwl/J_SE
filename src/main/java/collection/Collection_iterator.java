package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合提供了遍历元素的通用办法：迭代器模式
 * 
 * Iterator iterator()
 * Collection提供的iterator()方法可以获取一个用来遍历
 * 当前集合的迭代器实现类
 * 
 * java.util.Iterator
 * 迭代器，它是一个接口，规定了迭代器用来遍历集合的相关方法
 * 不同的集合实现类都提供了一个可以遍历自身的迭代器实现类。
 * 
 * 迭代器遍历集合遵循的操作为：
 * 问，取，删。其中删除元素不是必要操作.
 * @author JAVA
 *
 */
public class Collection_iterator {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		System.out.println(c);
		
		//获取用来遍历当前集合的迭代器
		Iterator it = c.iterator();
		/*
		 * boolean hasNext()
		 * 判断集合是否含有下一个元素可以遍历
		 * E next()
		 * 取出下一个元素
		 */
		while (it.hasNext()) {
			//it.next()在循环体中只能出现一次,否则发生NoSuchElementException,因此必须用变量接收后使用
			String str = (String) it.next();
			if ("#".equals(str)) {
				/*
				 * 迭代器在遍历集合时不允许通过集合的相关方法增删元素
				 */
//				c.remove(str);
				it.remove();
			}
		}
		System.out.println(c);
	}
}
