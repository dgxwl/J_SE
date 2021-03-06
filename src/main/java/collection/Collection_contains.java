package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 判断集合是否包含给定元素
 * @author JAVA
 *
 */
public class Collection_contains {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("java");
		c.add("c");
		c.add("c++");
		c.add("c#");
		c.add("android");
		c.add("ios");
		/*
		 * boolean contains(E e)
		 * 判断当前集合是否包含给定元素
		 * 判断标准是根据给定元素与集合现有元素equals
		 * 比较的结果。
		 */
		boolean contains = c.contains("c++");
		System.out.println("是否包含： " + contains);
		
		Collection c2 = new ArrayList();
		c2.add("c");
		c2.add("java");
		c2.add("android");
//		c2.add("php");
		
		//判断c集合是否包含c2集合中的所有元素
		boolean containAll = c.containsAll(c2);
		System.out.println("全包含：" + containAll);
		
		/*
		 * Collections.frequency(c, o)
		 * 参数c传入一个集合, o传入一个值
		 * 返回值o在集合c中的个数
		 */
		Collection c3 = new ArrayList<>(c2);
		c3.add("c");
		int frequency = Collections.frequency(c3, "c");
		System.out.println(frequency);
	}
}
