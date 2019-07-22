package collection;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 《Effective Java 第二版》第43条: "返回零长度的数组或者集合, 而不是null"
 * @author Administrator
 *
 */
public class Collections_emptyXX {

	public static void main(String[] args) {
		/*
		 * 如果getList()返回null, 下面处理list前需要判断, 否则会报NPE;
		 * 当getList()无数据可返回时, 应返回零长度list而不是null, 调用方可以省去判空操作
		 */
		List<String> list = getList();
		for (String string : list) {
			System.out.println(string);
		}
		
		Set<Integer> set = getSet();
		for (Integer integer : set) {
			System.out.println(integer);
		}
		
		Map<String, Object> map = getMap();
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		int[] arr = getArray();
		for (int i : arr) {
			System.out.println(i);
		}
		
		System.out.println("执行到最后了, 没有报NPE");
	}

	public static List<String> getList() {
//		return null;
		return Collections.emptyList();  //Collections工具类中提供的获得空集合的方法
	}
	
	public static Set<Integer> getSet() {
//		return null;
		return Collections.emptySet();
	}
	
	public static Map<String, Object> getMap() {
//		return null;
		return Collections.emptyMap();
	}
	
	public static int[] getArray() {
//		return null;
		return new int[0];
	}
}
