package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序含有自定义类型元素的list集合
 * @author JAVA
 *
 */
public class Collections_sort2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		
		list.add(new Point(6, 7));
		list.add(new Point(1, 3));
		list.add(new Point(2, 7));
		list.add(new Point(8, 4));
		list.add(new Point(9, 5));
		
		System.out.println(list);
		/*
		 * Collections.sort(List list)
		 * 该方法要求集合元素必须实现Comparable接口
		 */
		Collections.sort(list);
		
		System.out.println(list);
	}
}
