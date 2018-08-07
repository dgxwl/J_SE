package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map支持三种遍历方式:
 * 1:遍历所有的key
 * 2:遍历每一组键值对
 * 3:遍历所有的value(不常用)
 * @author JAVA
 *
 */
public class Map_itrerate {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		
		/*
		 * 遍历所有的key
		 * Set<K> keySet()
		 * 将当前Map中的所有key存入一个Set集合后返回。
		 * 遍历这个集合就等于遍历了所有的key
		 */
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println("key:" + key);
		}
		
		/*
		 * 遍历每一组键值对
		 * Map中每一组键值对是由Map的内部类Entry的
		 * 一个实例表示的（Entry是Map的内部接口，不同
		 * 的Map实现类都会实现Entry接口，用实现类的每一个
		 * 实例表示一个实际的键值对）。
		 * 
		 * Set<Entry> entrySet()
		 * 将当前Map中的每组键值对（若干的Entry实例）存入
		 * 到一个Set集合后返回.
		 */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> e : entrySet) {
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key + ":" + value);
		}
		
		/*
		 * 获取所有的value
		 * 
		 * Collection values()
		 * 获取当前map中所有的value.
		 */
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println("value: " + value);
		}
	}
}
