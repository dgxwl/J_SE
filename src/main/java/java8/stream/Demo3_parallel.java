package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * stream的串行和并行
 * 串行即顺序流;
 * 并行:将元素划分为多个数据块,在不同的线程中进行处理,最后合并处理结果;
 * 
 * 如何使用并行流:
 * 数据量不大时,效率得不到提升;
 * 单个元素处理时间越短性能越好;
 * 进行limit()、findFirst()等依赖元素顺序的操作极其消耗性能
 */
public class Demo3_parallel {
	public static void main(String[] args) {
		IntStream is = IntStream.of(1, 2, 3);  //串行
		/*
		 * boolean isParallel() 判断是否为并行流
		 */
		boolean isParallel = is.isParallel();
		System.out.println(isParallel);  //false
		/*
		 * *Stream parallel()
		 * 顺序流转为并行流
		 */
		is.parallel();
		System.out.println(is.isParallel());  //true
		/*
		 * *Stream sequential()
		 * 并行流转为顺序流
		 */
		is.sequential();
		System.out.println(is.isParallel());  //false
//		is.parallel().sequential().parallel().sequential().parallel().sequential();   ⊙ω⊙
		
		List<String> list = Arrays.asList("C", "C++", "Java", "C#", "JavaScript", "Python");
		/*
		 * Optional<T> findFirst()
		 * 获取stream中第一个元素的optional
		 * ps: 能从stream直接获取的只有第一个元素
		 */
		Optional<String> o1 = list.stream()
				.sorted((str1, str2) -> str1.length() - str2.length())
				.findFirst();
		System.out.println(o1.get());
		/*
		 * Stream<E> Collection.parallelStream() 从集合中获取并行流
		 * 
		 * Optional<T> findAny()
		 * 获取第一个元素,在并行流中与findFirst()无区别;
		 * 在并行流中,返回最快执行完的线程的第一个元素;
		 * 如果对数据没有顺序要求,使用findAny()效率更高
		 */
		Optional<String> o2 = list.parallelStream().findAny();
		System.out.println(o2.get());
	}
}
