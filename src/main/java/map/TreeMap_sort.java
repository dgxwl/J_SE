package map;

import java.util.Map;
import java.util.TreeMap;

/**
 * 自动排序的TreeMap使用实例
 * @author Administrator
 *
 */
public class TreeMap_sort {
	public static void main(String[] args) {
		/*
		 * 自动将所有key-value进行按key排序
		 */
		Map<Integer, String> map = new TreeMap<>();
		map.put(5, "haha");
		map.put(4, "hehe");
		map.put(2, "xixi");
		map.put(1, "heihei");
		map.put(3, "...");
		
		System.out.println(map);
		
		/*
		 * 可在构造方法中传入比较器, 所有key-value按key和指定比较器排序
		 */
		Map<String, String> map2 = new TreeMap<>((o1, o2) -> o1.length() - o2.length());
		map2.put("O1b", "M268");
		map2.put("O1b1a1a1a1a1", "M88");
		map2.put("O", "M175");
		map2.put("O1b1a1", "PK4");
		map2.put("O1", "F265");
		
		System.out.println(map2);
	}
}
