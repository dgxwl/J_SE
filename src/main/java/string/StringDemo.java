package string;
/**
 * 字符串频繁修改带来的性能损耗
 * @author JAVA
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		String str = "a";
		for (int i=0; i<10000000; i++) {
			str += "a";
		}
		System.out.println("执行完了");
	}
}
