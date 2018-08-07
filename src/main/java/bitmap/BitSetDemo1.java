package bitmap;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * BitSet是bitmap算法的简单实现;
 * 用1bit来表示数据是否出现过(0未出现,1出现),可处理大量数据.
 * 非多线程安全.
 * @author Administrator
 *
 */
public class BitSetDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {
			list.add(random.nextInt(1000));
		}
		System.out.println(list);
		
		BitSet bitSet = new BitSet();
		//去重并排序
		for (Integer num : list) {
			//void set(int bitIndex) 将int数据存入bitset
			bitSet.set(num);
		}
		System.out.println(bitSet);
		
		//求以上随机数中未出现的数
		for (int i = 0; i < 1000; i++) {
			//boolean get(int bitIndex) 查询bitIndex在bitset中是否已存在,返回boolean值
			if (!bitSet.get(i)) {
				System.out.print(i + ", ");
			}
		}
		System.out.println();
		
		//int cardinality() 获取bitset中为true的位数(即所存数据个数)
		int num = bitSet.cardinality();
		System.out.println("cardinality: " + num);
		
		//int size() 获取bitset实际使用的空间长度(位数),为64(long的长度)的倍数
		num = bitSet.size();
		System.out.println("size: " + num);
		
		//int length() 获取bitset的"逻辑大小",即最高设置位的索引+1(索引是所存的数据,因此length为所存数中的最大值+1)
		num = bitSet.length();
		System.out.println("length: " + num);
		
		//删除指定数据(该bit设置为false)
		bitSet.clear(100);
		
		//清除bitset中的所有数据(所有bit设置为false)
		bitSet.clear();
		System.out.println(bitSet);
		
	}
}
