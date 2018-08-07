package collection;

import java.util.ArrayList;
import java.util.Collection;

import object.Point;

/**
 * 删除集合元素
 * @author JAVA
 *
 */
public class Collection_remove {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1, 2));
		c.add(new Point(3, 4));
		c.add(new Point(5, 6));
		c.add(new Point(1, 2));
		System.out.println(c);
		
		Point p = new Point(1, 2);
		/*
		 * boolean remove(E e)
		 * 从集合中删除给定元素
		 * 集合不要求给定元素必须在集合中，因为删除元素
		 * 的判断标准是删除集合中与给定元素equals比较
		 * 为true的元素。对于List集合而言，若有重复的
		 * 只删除第一个
		 */
		c.remove(p);
		System.out.println(c);
	}
}
