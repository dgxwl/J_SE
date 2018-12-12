package java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda表达式
 * JDK1.8之后退出的一个新特性
 * lambda可以快速且简洁地定义匿名内部类.
 * 
 * 使用lambda表达式替代匿名内部类创建的要求：
 * 该接口或类必须有且只能有一个方法。
 * 
 * 通常重写的这个方法中只有一句代码时才使用lambda表达式
 * 
 * lambda表达式是编译器认可，最终在编译成class文件时会
 * 改为使用内部类实现。
 * 
 * 语法：
 * ([Arg1, a1, Arg2 a2....])->{代码片段}
 * 若lambda表达式的代码片段只有一句代码，可以不写"{}"
 * @author JAVA
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Adam");
		list.add("Christina");
		list.add("David");
		System.out.println(list);
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(list);
		/*
		 * 如果只有一句话，那么在省略"{}"的同时，这句话也不能添加";".
		 * 并且需要返回值的时候，也无需添加"return"
		 * 匿名内部类与lambda表达式对应的部分：
		 * 参数部分	      方法体
		 * (xxxx) -> {xxxxx}
		 * 
		 * 在使用lambda后，无需在指定匿名内部类实现的超类或
		 * 接口的名字，并且重写的方法的名字也无需指定。编译器
		 * 会根据实际情况分析出相关信息.
		 */
		Collections.sort(list, (String o1, String o2) -> o2.length() - o1.length());
		System.out.println(list);
	}
}
