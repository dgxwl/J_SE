package exception;
/**
 * 测试异常的抛出与处理
 * @author JAVA
 *
 */
public class Exception_throw {
	public static void main(String[] args) {
		Person p = new Person();
		/*
		 * 当调用一个含有throws声明异常抛出的方法时
		 * 编译器要求这里必须处理该异常。
		 * 处理手段有两种：
		 * 1：使用try-catch捕获并处理
		 * 2：在当前方法上继续使用throws将异常声明抛出
		 */

		try {
			p.setAge(95);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}

		
		System.out.println("年龄：" + p.getAge());
	}
}
