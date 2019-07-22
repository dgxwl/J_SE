package java8.optional;

import java.util.Optional;
import java.util.Random;

/**
 * optional的运用: 通过链式调用Optional的方法,避免NullPointerException
 * 
 * @author Administrator
 *
 */
public class OptionalDemo {
	public static void main(String[] args) {
		Person person = null;
		if (new Random().nextInt() <= 4) {
			 person = new Person(23, "abc");
		}

		// 以前写法
		if (person != null) {
			System.out.println(person);
		}

		// 新写法
		Optional.ofNullable(person).ifPresent(System.out::println);

		try {
			// 以前验证非空并抛异常的写法
			if (person != null) {
				String name = person.getName();
				if (name != null) {
					System.out.println(name.charAt(0));
				}
			} else {
				throw new RuntimeException("null");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		try {
			// Optional写法
			Optional.ofNullable(person).map(p -> p.getName()).map(name -> name.charAt(0))
					.orElseThrow(() -> new RuntimeException("null"));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		Person pp = Optional.ofNullable(person)
							.orElse(new Person(23, "zhangsan"));
		System.out.println(pp);

		Person ppp = Optional.ofNullable(person)
							.filter(p -> "zhangsan".equals(p.getName()))
							.orElseGet(() -> {
								System.out.println("定义了一个匿名方法返回一个值");
								return new Person(23, "zhangsan");
							});
		System.out.println(ppp);
	}
}
