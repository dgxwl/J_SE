package collection;

import java.util.ArrayList;
import java.util.Collection;

import object.Point;

/**
 * 集合存放的是元素的引用（地址），而不是对象本身。
 * @author JAVA
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		Point p = new Point(1, 2);
		c.add(p);
		
		System.out.println("p: " + p);
		System.out.println("c: " + c);
		
		p.setX(2);
		System.out.println("p: " + p);
		System.out.println("c: " + c);
		
		dosome(c, p);
		System.out.println("p: " + p);
		System.out.println("c: " + c);
	}
	
	public static void dosome(Collection c, Point p) {
		c.add(new Point(3, 3));
		c = new ArrayList();
		c.add(p);
		p.setX(4);
		System.out.println("p: " + p);
		System.out.println("c: " + c);
	}
}
