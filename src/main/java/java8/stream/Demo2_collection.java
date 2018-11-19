package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通过集合获取stream并进行转换等操作
 * 
 * @author dgxwl
 *
 */
public class Demo2_collection {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 7, 7, 8, 8, 8);
		/*
		 * Stream<E> stream() 从集合中获取stream;每次调用都返回一个新的stream
		 * Stream<T> distinct() 对stream中的元素进行去重,返回一个新的stream
		 * void forEach(Consumer<? super T> action) 根据指定action遍历元素; Consumer:消费函数
		 */
		list.stream().distinct().forEach(System.out::print);
		System.out.println();
		/*
		 * Stream filter(元素 -> 元素满足条件)  从原stream筛选出满足条件的元素生成新的stream
		 */
		list.stream().filter(l -> l > 5).forEach(System.out::print);
		System.out.println();
		/*
		 * Stream<R> map(Function<? super T, ? extends R> mapper)
		 * 根据给定规则参数生成新的stream,元素类型可能与原stream不同;
		 * 三种特殊化的方法mapToInt() mapToLong() mapToDouble(),
		 * 指定新stream的元素类型, 可避免自动拆装箱的消耗
		 */
		list.stream().map(l -> (char)(l + 64)).forEach(System.out::print);
		list.stream().mapToInt(l -> l * 2).forEach(System.out::print);
		list.stream().mapToLong(l -> l * 2).forEach(System.out::print);
		list.stream().mapToDouble(l -> l * 2).forEach(System.out::print);
		System.out.println();
		/*
		 * Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
		 * 将多维的集合展开成一维(扁平化), 与map()类似
		 */
		List<List<Integer>> groups = new ArrayList<>();
		groups.add(Arrays.asList(1, 2, 3));
		groups.add(Arrays.asList(4, 5, 6));
		groups.add(Arrays.asList(7, 8, 9));
		groups.stream().flatMap(l -> l.stream()).forEach(System.out::print);
		System.out.println();
		/*
		 * Stream<T> peek(Consumer<? super T> action)
		 * 对stream中元素执行给定的操作; Consumer:消费函数
		 */
		list.stream().peek(l -> l++).forEach(System.out::print);
		System.out.println();
		/*
		 * Stream<T> limit(long maxSize)
		 * 对stream进行截取,获取前maxSize个元素
		 */
		list.stream().limit(3).forEach(System.out::print);
		System.out.println();
		/*
		 * Stream<T> skip(long n)
		 * 跳过前n个元素,获取剩下的元素
		 */
		list.stream().skip(10).forEach(System.out::print);
		System.out.println();
		
		List<Integer> list2 = Arrays.asList(3, 9, 4, 0, 5, 2, 1, 8, 6);
		/*
		 * Stream<T> sorted()
		 * 对stream中的元素进行排序,返回新的stream;
		 * 另有传入比较器的重载: Stream<T> sorted(Comparator<? super T> comparator)
		 */
		list2.stream().sorted().sorted((a, b) -> b - a).forEach(System.out::print);
		System.out.println();
		
	}
}
