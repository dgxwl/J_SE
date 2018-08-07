package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map 查找表
 * 
 * Map是java中一个非常经典的数据结构，体现的二结构是一个多行两列的表格。
 * 第一列称为：Key  第二列称为：Value
 * 所以Map是以key-value对的形式保存数据。
 * Map有一个要求，在Map中不允许有重复的key（equals比较）
 * 
 * 查询通常是根据key查找其对应的value
 * 
 * Map是一个接口，最常用的实现类：java.util.HashMap散列表
 * 
 * 
 * @author JAVA
 *
 */
public class Map_put_get {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		/*
		 * V put(K k, V v)
		 * 将给定的key,value对存入Map中.
		 * 由于Map的Key不允许重复，所以若使用Map中已有
		 * 的Key去存放Value则是替换value操作。put方法
		 * 的返回值会将被替换的value返回。若该key在map中
		 * 不存在，则返回值为null。
		 */
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		
		System.out.println(map);
		
		//替换value操作
		System.out.println(map.put("数学", 100));
		System.out.println(map);
		
		int size = map.size();
		System.out.println("size:" + size);
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value
		 * 若给定的key在当前Map中不存在则返回null
		 * 
		 * 若Map中的value的类型为包装类，那么需要注意
		 * 在接收get()方法返回值时要使用包装类来接收，
		 * 避免触发自动拆箱特性，否则可能引发空指针。
		 */
		Integer value = map.get("语文");
		System.out.println(value);
		
		/*
		 * V remove(K k)
		 * 删除Map中给定key所对应的key-value对。
		 * 返回值为被删除的key-value对中的value。
		 */
		value = map.remove("英语");
		System.out.println(map);
		System.out.println(value);
	}
}
