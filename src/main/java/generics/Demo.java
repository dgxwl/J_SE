package generics;

import java.util.List;

/**
 * 定义泛型类、方法、接口
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		Box<Exception> box = new Box<>(new Exception());
		box.desc();
		
		gMethod("abc");
	}
	
	//泛型方法
	public static <T> void gMethod(T t) {
		System.out.println(t.getClass());
	}
}

//泛型类
class Box<T> {
	private T toy;
	
	public Box(T toy) {
		this.toy = toy;
	}

	public void desc() {
		System.out.println("Your toy is a " + toy.getClass().toString().substring(6) + ".");
	}
}

//泛型接口
interface Inter<T> {
	T nextOne();
}
//不指定类型实现
class Impl<T> implements Inter<T> {
	public T nextOne() { return null; }
}
//指定类型实现
class Impl2 implements Inter<String> {
	public String nextOne() { return null; }
}

//限制泛型可用类型为某个类、接口或它的子类、实现类
class Limit<T extends List<?>> {
	//blabla
}