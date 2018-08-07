package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合操作
 * @author JAVA
 *
 */
public class Collection_addAll {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		c1.add("java");
		c1.add("c");
		c1.add("c++");
		System.out.println("c1: " + c1);
		
		Collection c2 = new HashSet();
		c2.add("android");
		c2.add("ios");
		c2.add("java");
		System.out.println("c2: " + c2);
		
		//将c2中的所有元素添加到c1中
		c1.addAll(c2);
		System.out.println("c1: " + c1);
		
		Collection c3 = new ArrayList();
		c3.add("c");
		c3.add("android");
		c3.add("php");
		System.out.println("c3: " + c3);
		
		//删除c1中与c3共有的元素
		c1.removeAll(c3);
		System.out.println("c1: " + c1);
	}
}
