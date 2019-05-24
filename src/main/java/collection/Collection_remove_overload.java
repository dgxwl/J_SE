package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 《Effective Java》书中的例子(第41条).由于重载带来的错误
 * @author Administrator
 *
 */
public class Collection_remove_overload {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();
		
		//存入[-3, -2, -1, 0, 1, 2]
		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}
		System.out.println(set);
		System.out.println(list);
		
		//移除非负数[0, 1, 2]
		for (int i = 0; i < 3; i++) {
			set.remove(i);
			/*
			 * 由于List有一个重载的、根据index删除元素的Object remove(int index)方法, 
			 * 未触发自动装箱, 导致未删除元素而是删除了下标对应元素; 此处应对参数手动装箱, 改为
			 * list.remove(Integer.valueOf(i));
			 */
			list.remove(i);
		}
		System.out.println(set);  //[-3, -2, -1], 正确的
		System.out.println(list);  //[-2, 0, 2], 错误结果
	}
}
