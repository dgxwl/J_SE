package java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Java8新特性: java.util.Stream, 支持顺序和并行聚合操作的一系列元素.
 * 
 * @author dgxwl
 *
 */
public class Demo {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two", null, "three", "four", null, "five");
		
		//从集合中获取stream
		list.stream();
		/*
		 * Stream filter(元素 -> 元素满足条件)  从原stream筛选出满足条件的元素生成新的stream
		 * long count() 聚合运算(类似sql)
		 */
		list.stream().filter(l -> l != null).count();
	}
}
