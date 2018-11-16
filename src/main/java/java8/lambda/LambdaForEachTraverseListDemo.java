package java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用forEach()配合Lambda遍历List
 * @author Administrator
 *
 */
public class LambdaForEachTraverseListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Visual Basic");
		list.add("C");
		list.add("C++");
		list.add("Java");
		list.add("C#");
		list.add("JavaScript");
		list.add("Python");
		
		list.forEach(item -> System.out.println(item));
		System.out.println();
		list.forEach(item -> {
			if (item.startsWith("C")) {
				System.out.println("startWith C: " +item);
			}
		});
	}
}
