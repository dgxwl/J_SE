package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map可以判断是否包含给定的key或value
 * @author JAVA
 *
 */
public class Map_contains {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		
		boolean ck = map.containsKey("化学");
		System.out.println("包含key:" + ck);
		boolean cv = map.containsValue(98);
		System.out.println("包含value:" + cv);
	}
}
