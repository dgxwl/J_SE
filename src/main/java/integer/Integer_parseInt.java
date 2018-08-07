package integer;
/**
 * 包装类提供了一个静态方法：parseXXX(String str)
 * 可以将给定的字符串转换为对应的基本类型数据，前提是
 * 该字符串表示的内容能正确描述基本类型可以保存的值。
 * @author JAVA
 *
 */
public class Integer_parseInt {

	public static void main(String[] args) {
		String str = "123.123";
//		String str = "123";
//		int i = Integer.parseInt(str);
//		System.out.println(i);
		
		double d = Double.parseDouble(str);
		System.out.println(d);
	}

}
