package exception;
/**
 * 使用这个类测试异常的抛出
 * 
 * 通常当遇到下列情况时可以主动抛出异常：
 * 1：当发生了一个异常，但是该异常的处理不应当在当前代码
 * 	片段中完成时，可以抛出到方法之外由调用者处理。
 * 2：当遇到一个满足语法要求但是不满足业务逻辑要求的情况时，
 * 	可以主动抛出一个异常告知调用者这样做不可以。
 * 
 * 通过throw关键字可以将异常抛出。
 * 
 * @author JAVA
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/**
	 * 当一个方法中使用throw抛出某个异常时就应当在
	 * 方法声明时使用throws声明该类异常的抛出，以通知
	 * 调用者处理该异常。
	 * 只有RuntimeException及其子类型异常在使用throw
	 * 抛出时可以不再方法上使用throws声明者类异常的抛出
	 * 其他类型的异常时强制要求必须做的。否则编译不通过.
	 * 
	 * java将异常分为检查异常与非检查异常：
	 * RuntimeException及其子类型异常时非检查异常，
	 * 其他类型的异常都是检查异常.
	 * 
	 * 非检查异常指的是当程序抛出一个非检查异常时，编译器
	 * 不检查该代码片段是否有处理这个异常的手段。而检查异常
	 * 则要求必须有处理手段否则编译不通过。
	 * @param age
	 * @throws Exception
	 */
	public void setAge(int age) throws IllegalAgeException {
		if (age<0 || age>100) {
			throw new IllegalAgeException("年龄不合法");
		}
		this.age = age;
	}
	
	
}
