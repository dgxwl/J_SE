package java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java8.optional.Person;


public class List_sort2 {
	public static void main(String[] args) {
		List<Person> l = new ArrayList<>();
		l.add(new Person(33, "David"));
		l.add(new Person(22, "Sally"));
		l.add(new Person(44, "Tom"));
		l.add(new Person(23, "David"));
		
		/*
		 * Comparator<T> comparing(Function<? super Person, ? extends String> keyExtractor)
		 * 传入一个方法引用(Function类型)作为排序的key, 返回比较器
		 * 
		 *  Comparator<Person> thenComparing(Function<? super Person, ? extends Integer> keyExtractor)
		 *  传入一个方法引用(Function类型)作为排序的key, 返回比较器; 多条件组合排序用
		 */
		l.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
		System.out.println(l);
	}
}
