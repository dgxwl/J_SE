package optional;

import java.util.Optional;

/**
 * 为了优化防止空指针而写的if(xx != null) {} 这样的繁琐写法,
 * Java8提供了Optional类, 它是一个包装null或non-null对象
 * (内部定义了一个private final T value来保存)的容器.
 * @author Administrator
 *
 */
public class OptionalAllMethod {
	public static void main(String[] args) {
		Person p1 = null;
		Person p2 = new Person(28, "zhangsan");
		
		/*
		 * static <T> Optional<T> of(T value)
		 * 返回一个指定值的Optional,如果指定的值为null,仍然会报NullPointerException,
		 * 可用于发现null值时立即报告(因此很少用)
		 */
		Optional<Person> opt1 = Optional.of(new Person(23, "abc"));
		System.out.println(opt1);
		
		/*
		 * static <T> Optional<T> ofNullable(T value)
		 * 如果参数value非空,返回 Optional描述的指定值,否则返回Optional内部的EMPTY;
		 * EMPTY在Optional类中的声明: private static final Optional<?> EMPTY = new Optional<>()
		 */
		Optional<Person> opt2 = Optional.ofNullable(p1);
		System.out.println(opt2);
		
		//static<T> Optional<T> empty()  返回一个内部value为null的Optional对象
		Optional<Person> opt3 = Optional.empty();
		System.out.println(opt3);
		
		//*****************以上是Optional类的静态方法***********************
		
		Optional<Person> opt4 = Optional.of(p2);
		
		//T get()  如果value非空则返回,否则抛出NoSuchElementException
		Person i = opt4.get();
		System.out.println(i);
		
		//boolean isPresent()  如果value非空则返回true,否则返回false
		boolean b = opt4.isPresent();
		System.out.println(b);
		
		/*
		 * void ifPresent(Consumer<? super T> consumer)
		 * 如果value非空则执行Consumer内的代码, 否则不执行;
		 * p即从Optional中的value
		 */
		opt1.ifPresent(p -> {
			System.out.println("not null, " + p);
		});
		
		//T orElse(T other)  如果value非空则返回value,否则返回指定参数的值
		i = opt2.orElse(new Person(23, "default"));
		System.out.println(i);
		
		/*
		 * T orElseGet(Supplier<? extends T> other)
		 * 如果value非空则返回value,否则返回指定方法的返回值
		 */
		i = opt2.orElseGet(() -> getDefaultValue());
		System.out.println(i);
		
		/*
		 * <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
		 * 如果value非空则返回value,否则抛出一个指定的异常
		 */
		try {
			i = opt2.orElseThrow(() -> new RuntimeException("值为空."));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		/*
		 * Optional<T> filter(Predicate<? super T> predicate)
		 * 过滤出某个属性符合给出条件的对象
		 */
		Optional<Person> op = opt1.filter(p -> p.getAge() < 30);
		System.out.println(op);
		
		/*
		 * Optional<U> map(Function<? super T, ? extends U> mapper)
		 * 如果调用map()的opt中value不为null,可传入一个函数,map()返回包装这个函数的
		 * 返回值的Optional对象
		 */
		String name = opt1.map(p -> p.getName()).get();
		System.out.println(name);
		
		//flatMap()  如果getName()定义的返回值是Optional<String>, 可以flatMap()效果与map()相同
//		String name = opt1.flatMap(p -> p.getName()).get();
//		System.out.println(name);
	}
	
	static Person getDefaultValue() {
		return new Person(0, "default");
	}
}


