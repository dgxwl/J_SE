package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections_sort3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Christina");
		list.add("Jack");
		list.add("David");
		
		System.out.println(list);
		/*
		 * 该sort()方法要求元素必须可比较，在实际开发中会有很多不便，
		 * 比如元素的比较规则不满足我们排序需求。而且该方法要求元素必须
		 * 实现接口，这对我们程序扩展也不利。
		 */
//		Collections.sort(list);
		/*
		 * Collections提供了一个重载的sort()方法，
		 * 该方法要求再传入一个比较器。然后该sort()方法会根据给定
		 * 的比较器的比较规则将集合元素顺序比较大小后进行自然排序。
		 * 当集合元素自身的比较规则不满足排序需求，或者排序的集合元素
		 * 是自定义的类型时，都应当使用这种排序方法
		 */
		//按照字符多少排序
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(list);
	}
}
