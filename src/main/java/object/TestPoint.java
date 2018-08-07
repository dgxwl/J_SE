package object;
/**
 * 测试Point重写的Object相关方法
 * @author JAVA
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point p = new Point(1, 2);
		/**
		 * Object提供了toString()方法，返回的字符串是
		 * 该对象的句柄信息，类名@地址
		 * 通常Object的toString()返回的句柄对实际开发
		 * 意义不大.
		 * 所以当我们定义的类需要使用toString()方法时，
		 * 就应当重写它.
		 */
		System.out.println(p.toString());
		System.out.println(p);
		
		Point p2 = new Point(1, 2);
		System.out.println(p==p2);
		/*
		 * Object定义的equals()方法作用是比较当前
		 * 对象与参数对象内容是否一样。但是Object
		 * 本身实现的逻辑是用"=="，所以若不重写
		 * 该方法则没有实际意义。
		 */
		System.out.println(p.equals(p2));
	}
}
