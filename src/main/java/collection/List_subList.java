package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List可以获取子集
 * @author JAVA
 *
 */
public class List_subList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		/*
		 * List subList(int start, int end)
		 * 获取当前集合指定范围内的子集
		 */
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);
		
		/*
		 * 将子集元素扩大10倍
		 * [30, 40, 50, 60, 70]
		 */
		for (int i = 0; i < subList.size(); i++) {
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(subList);
		System.out.println(list);
	}
}
