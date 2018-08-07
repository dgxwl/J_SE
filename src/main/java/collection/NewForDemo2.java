package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 使用新循环遍历集合
 * @author JAVA
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		/*
		 * 新循环遍历集合就是迭代器遍历。所以不要在遍历的过程中增删元素
		 * 
		 * 新循环是编译器认可的，编译器会在编译源代码时将新循环擦除，改为
		 * 使用迭代器遍历集合。
		 */
		for (Object o : c) {
//			Iterator it = c.iterator();
//			while (it.hasNext()) {
//			Object o = it.next();
			String str = (String) o;
//			if ("#".equals(str)) {
//				c.remove(str);
//			}
			System.out.println(str);
		}
		System.out.println(c);
	}
}
