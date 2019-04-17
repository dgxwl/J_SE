package java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class List_sort1 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("Mary");
		l.add("David");
		l.add("Lucy");
		l.add("Tom");
		
		System.out.println(l);
		
		/*
		 * Java8的List接口中加入了void sort(Comparator<? super String> c)方法
		 */
		l.sort(null);
		System.out.println(l);
		
		//lambda表达式定义一个Comparator
		Comparator<String> c = (str1, str2) -> str1.compareTo(str2);
		/*
		 * Comparator<T> Comparator.reversed()
		 * 获得一个倒序排序的比较器
		 */
		l.sort(c.reversed());
		System.out.println(l);
	}
}
