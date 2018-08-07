package string;

/**
 * Java8的String添加了新的方法join():
 * static String join(CharSequence delimiter, CharSequence... elements),
 * 可将几段字符串用指定分隔符拼接成一个长字符串.
 * @author Administrator
 *
 */
public class String_join {
	public static void main(String[] args) {
		/*
		 * join()的参数都是CharSequence(字符序列)类型, 
		 * 即意味着参数可以为String, StringBuffer, StringBuilder等;
		 * 第一个参数是指定的分隔符. 后面的是可变参数, 即需要拼接的所有字符串
		 */
		String str = String.join(", ", "aaa", "bbb", "ccc");
		System.out.println(str);
	}
}


