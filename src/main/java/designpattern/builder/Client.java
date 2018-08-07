package designpattern.builder;

/**
 * 使用Builder模式,弥补了重叠构造器模式多参数时难以阅读的
 * 不足,同时具有JavaBeans模式的可读性,并且生成的对象是不可变的
 * (比JavaBeans更安全);
 * Builder模式还实现了流式编程风格(Fluent interface).
 * 不足:为创建对象还必须创建Builder对象需要额外开销;由于Builder模式
 * 比重叠构造器模式还更冗长,因此在传入很多参数的时候才使用(4个以上).
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Person p = new Person.Builder(1)
							.name("zhangsan")
							.gender("male")
							.age(19)
							.build();
		System.out.println(p);
	}
}
