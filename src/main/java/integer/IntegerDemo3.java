package integer;
/**
 * JDK1.5之后推出了一个特性：自动拆装箱
 * 该特性允许我们在源代码中使基本类型与其对应的包装类
 * 之间互相赋值而无需在添加额外代码做转换工作。
 * 但是编译器会将代码编译为class文件时自动添加转换
 * 代码。
 * @author JAVA
 *
 */
public class IntegerDemo3 {

	public static void main(String[] args) {
		/*
		 * 触发编译器自动装箱特性：
		 * 编译器会补全代码为：
		 * Integer i = Integer.valueOf(123);
		 */
		Integer i = 123;
		/*
		 * 触发编译器自动拆箱特性：
		 * 编译器会补全代码为：
		 * int d = i.intValue();
		 */
		int d = i;
		
		System.out.println(d);
		System.out.println(i);
	}

}
