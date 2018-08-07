package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * java.util.Collections 集合的工具类
 * Collections中定义很多静态方法，都是用来操作集合的。
 * 
 * 其中一个静态方法：sort()是用来对List集合进行自然排序的
 * 即：从小到大排序
 * @author JAVA
 *
 */
public class Collections_sort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(100));
		}
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
