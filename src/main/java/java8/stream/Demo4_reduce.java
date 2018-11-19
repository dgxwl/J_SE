package java8.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * stream的归约操作
 * @author Administrator
 *
 */
public class Demo4_reduce {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 9, 4, 0, 5, 2, 1, 8, 6);
		
		/*
		 * Optional<T> reduce(BinaryOperator<T> accumulator)
		 * 传入一个规则参数指定上一次执行的返回值(第一次执行则返回stream的第一个元素)
		 * 与本次遍历的元素作何聚合操作,最终返回一个表示聚合值的optional对象
		 */
		Optional<Integer> op1 = list.stream().reduce((sum, item) -> sum + item); //所有元素相加
		System.out.println(op1.get());
		/*
		 * T reduce(T identity, BinaryOperator<T> accumulator)
		 * 传入identity指定第一次执行的值，其余同上;
		 * 如果stream为空(empty),则直接返回identity
		 */
		Integer i1 = list.stream().reduce(0, (count, item) -> ++count);  //统计元素个数
		System.out.println(i1);
		/*
		 * U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
		 * 不是很懂第三个参数combiner的作用...好像是说并行时的各自聚合?最终把结果合并?要与accumulator保持一致....?????
		 */
		Integer i2 = list.parallelStream().reduce(0, (sum, item) -> sum + item, (sum, item) -> sum + item);
		System.out.println(i2);
		
		/*
		 * long count()
		 * 统计stream元素数量;通常配合filter筛选
		 */
		long num = list.stream().filter(item -> item > 4).count();
		System.out.println("count: " + num);
		
		/*
		 * <R, A> R collect(Collector<? super T, A, R> collector)
		 * 传入collector参数,将stream元素转换成集合或字符串等;
		 * 可利用Collectors工具类获取各种collector
		 */
		List<Integer> filterList = list.stream().filter(item -> item > 5).collect(Collectors.toList());  //转换成list
		System.out.println(filterList + ", " + filterList.getClass());
		Set<Integer> set = list.stream().collect(Collectors.toSet());  //转成set
		System.out.println(set + ", " + set.getClass());
		String str = list.stream().map(item -> item + "").collect(Collectors.joining(","));  //转字符串
		System.out.println(str);
		
		/*
		 * boolean allMatch(Predicate<? super T> predicate)
		 * 判断是否所有元素符合给定逻辑表达式
		 */
		boolean allMatch = list.stream().allMatch(item -> item > 0);
		System.out.println(allMatch);
		/*
		 * boolean anyMatch(Predicate<? super T> predicate)
		 * 判断是否有任一元素符合给定逻辑表达式
		 */
		boolean anyMatch = list.stream().anyMatch(item -> item < 0);
		System.out.println(anyMatch);
		/*
		 * boolean noneMatch(Predicate<? super T> predicate);
		 * 判断是否所有元素都不符合给定逻辑表达式
		 */
		boolean noneMatch = list.stream().noneMatch(item -> item == 0);
		System.out.println(noneMatch);
		
		/*
		 * Optional<T> max(Comparator<? super T> comparator)
		 * 传入比较器参数, 获取元素最大值
		 * Optional<T> min(Comparator<? super T> comparator)
		 * 传入比较器参数, 获取元素最小值
		 */
		List<String> list2 = Arrays.asList("C", "C++", "Java", "C#", "JavaScript", "Python");
		Optional<String> max = list2.stream().max((a, b) -> a.length() - b.length());
		Optional<String> min = list2.stream().min((a, b) -> a.length() - b.length());
		System.out.println("max: " + max.get() + ", min: " + min.get());
		/*
		 * 对于IntStream、LongStream和DoubleStream,它们自带不需要比较器的
		 * int max()和int min(),还有可计算元素值总和的int sum()、
		 * 计算平均值的OptionalDouble average()
		 */
		IntStream is = IntStream.of(3, 9, 4, 0, 5, 2, 1, 8, 6);
		OptionalInt oi = is.max();
		System.out.println(oi.getAsInt());
		int sum = IntStream.of(3, 9, 4, 0, 5, 2, 1, 8, 6).sum();
		System.out.println(sum);
		OptionalDouble od = IntStream.of(0, 1, 2, 3, 4).average();
		double average = od.getAsDouble();
		System.out.println(average);
		/*
		 * summaryStatistics()
		 * 3个数据型stream具有此方法,返回一个状态类型,从这个状态类对象
		 * 可获取count, min, max, sum, average的值
		 */
		IntSummaryStatistics iss = IntStream.of(3, 9, 4, 0, 5, 2, 1, 8, 6).summaryStatistics();
		LongSummaryStatistics lss = LongStream.of(3, 4, 5, 6, 2).summaryStatistics();
		DoubleSummaryStatistics dss = DoubleStream.of(1.2, 1.3, 1.5).summaryStatistics();
		System.out.println("iss: " + iss.getAverage() + ", " + iss.getCount() + ", " + iss.getMax() + ", " + iss.getMin() + ", " + iss.getSum());
		System.out.println("lss: " + lss.getAverage() + ", " + lss.getCount() + ", " + lss.getMax() + ", " + lss.getMin() + ", " + lss.getSum());
		System.out.println("dss: " + dss.getAverage() + ", " + dss.getCount() + ", " + dss.getMax() + ", " + dss.getMin() + ", " + dss.getSum());
	}
}
