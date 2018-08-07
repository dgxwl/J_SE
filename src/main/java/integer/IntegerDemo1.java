package integer;
/**
 * 包装类
 * java中8个基本类型不具备面向对象特性，所以在实际开发
 * 中不能直接参与面向对象开发。为了解决这个问题，java对应
 * 的提供了8个包装类。
 * 其中六个数字类型的包装类继承自java.lang.Number
 * Number提供了一组抽象方法，允许包装类将其表示的数字在
 * 数字类型之间进行转换。
 * @author JAVA
 *
 */
public class IntegerDemo1 {

	public static void main(String[] args) {
//		int i = 128;
////		Integer i1 = new Integer(i);
////		Integer i2 = new Integer(i);
//		Integer i1 = Integer.valueOf(i);
//		Integer i2 = Integer.valueOf(i);
//		
//		System.out.println(i1 == i2);
//		System.out.println(i1.equals(i2));
		
		double i = 128.123;
		Double d1 = Double.valueOf(i);
		Double d2 = Double.valueOf(i);
		
		System.out.println(d1==d2);
		System.out.println(d1.equals(d2));
		
		double d = d1.doubleValue();
		System.out.println(d);
		int i1 = d1.intValue();
		System.out.println(i1);
	}

}
