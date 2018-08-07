package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型
 * JDK1.5之后推出的另一个特性
 * 
 * 泛型又称为参数化类型。常用在集合中来规定元素类型使用
 * @author JAVA
 *
 */
public class GenericDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		/*
		 * boolean add(E e)
		 * 由于集合的add方法参数类型是泛型，所以在这里
		 * 我们使用集合时实际传入的是String，编译器就会
		 * 检查我们调用add方法时实际传入的参数是否为字符串。
		 * 注意：泛型可以不指定，若不指定就是原型Object
		 */
		c.add("one");  //参数必须是String类型
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
		for (String str : c) {
			System.out.println(str);
		}
	}
}
