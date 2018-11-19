package java8.stream;

import java.util.Iterator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Java8新特性 java.util.Stream, 支持顺序和并行聚合操作的一系列元素(元素队列).
 * stream来源: 手动创建,数组,集合,IO通道,generator function(?)等;
 * 
 * 演示Stream接口静态方法创建
 * @author Administrator
 *
 */
public class Demo1_createByStaticMethod {
	public static void main(String[] args) {
		/*
		 * 接口静态方法Stream.of(T t)或Stream.of(T... values)
		 * 创建有序的含1个或多个元素的stream
		 */
		Stream<Integer> s1 = Stream.of(1);
		Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5);
//		s1.forEach(ele -> System.out.println(ele));
		s1.forEach(System.out::println);  //同上, 方法引用写法更简便
//		s1.forEach(System.out::println);  //对于同一个stream只能操作一遍, 之后stream会关闭, 再次操作将抛出IllegalStateException 
		s2.forEach(System.out::println);
		/*
		 * Java8提供了对应int,long,double类型的stream,
		 * 相当于Stream<Integer>,Stream<Long>,Stream<Double>,
		 * 应优先使用,可避免自动拆装箱的损耗,提高效率
		 */
		IntStream is = IntStream.of(1, 2, 3, 4);
		LongStream ls = LongStream.of(1, 2, 3, 4);
		DoubleStream ds = DoubleStream.of(1.0, 2.0, 3.0);
		System.out.println(is + "," + ls + "," + ds);
		/*
		 * Iterator<T> iterator()
		 * 从stream中获取迭代器
		 */
		Iterator<Integer> it = is.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		/*
		 * Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
		 * 创建一个lazy连接的流,其元素是第一个流的所有元素,后跟第二个流的所有元素;
		 *  如果两个输入流都是有序的,则对所得到的流进行排序;如果任一输入流是并行的,
		 *  则对其进行并行. 关闭结果流时，将调用两个输入流的关闭处理程序。
		 */
		Stream<Integer> s3 = Stream.concat(Stream.of(1,2,3), Stream.of(4,5,6));
		s3.forEach(System.out::println);
		/*
		 * Stream.Builder<T> builder()获取一个stream的builder
		 * Stream.Builder<T> java.util.stream.Stream.Builder.add(T t)添加元素
		 */
		Stream<Object> s4 = Stream.builder().add(1).add(2).add(3).build();
		System.out.println(s4);
		/*
		 *  Stream<Object> empty()获取一个空的有序stream
		 */
		Stream<Object> s5 = Stream.empty();
		System.out.println(s5);
		/*
		 * Stream<T> generate(Supplier<T> s)
		 * 通过重写的Supplier.get()提供的元素生成一个无限长stream; Supplier:生产者
		 * 适用于生成恒定值stream和随机数stream;无限长stream通常配合limit()使用
		 */
//		Stream<Double> s6 = Stream.generate(() -> Math.random());
		Stream<Double> s6 = Stream.generate(Math::random);  //同上, 方法引用写法更简便
		s6.limit(10).forEach(System.out::println);
		/*
		 * Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 * 根据给定初始元素种子和递归规则产生一个无限长stream
		 */
		Stream<Integer> s7 = Stream.iterate(1, t -> t * 2);  //1,2,4,8,16...
		s7.limit(10).forEach(System.out::println);
	}
}
