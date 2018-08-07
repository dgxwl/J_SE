package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了可以转换为数组的方法：toArray()
 * @author JAVA
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		
//		Object[] array = c.toArray();
		
		String[] array = c.toArray(new String[c.size()]);
		System.out.println(array.length);
		for (String st : array) {
			System.out.println(st);
		}
		System.out.println(Arrays.toString(array));
	}
}
