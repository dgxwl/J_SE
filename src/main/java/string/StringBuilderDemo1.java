package string;
/**
 * java.lang.StringBuilder
 * 由于String的设计天生不适合做修改操作，所以java提供
 * 一个专门负责修改字符串内容的类StringBuilder
 * StringBuilder内部维护一个可变的字符数组，以及提供了
 * 方便修改字符串内容的相关方法，所以所有修改字符串内容
 * 的操作都应当使用StringBuilder来完成
 * @author JAVA
 *
 */
public class StringBuilderDemo1 {

	public static void main(String[] args) {
		String str = "好好学习java";
		System.out.println(str);
		StringBuilder builder = new StringBuilder(str);
		builder.append("，为了找个好工作！");
		str = builder.toString();
		System.out.println(str);
		builder.replace(9, 16, "就是为了改变世界");
		System.out.println(builder.toString());
		builder.delete(0, 8);
		System.out.println(builder.toString());
		builder.insert(0, "活着");
		System.out.println(builder.toString());
	}

}
