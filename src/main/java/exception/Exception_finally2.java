package exception;
/**
 * 关于finally常见的面试题
 * 
 * 请分别描述：final, finally, finalize?
 * @author JAVA
 *
 */
public class Exception_finally2 {

	public static void main(String[] args) {
		System.out.println(
			test("1") + ", " + test(null) + ", " + test("")
		);
	}

	public static int test(String str) {
		try {
			System.out.println("开始执行test方法，str:" + str);
			return str.charAt(0) - '1';
		} catch (NullPointerException e) {
			System.out.println("空指针了!");
			return 1;
		} catch (Exception e) {
			System.out.println("下标越界了!");
			return 2;
		} finally {
			System.out.println("finally执行了!");
//			return 3;	finally一定会执行，方法返回前执行finally后退出异常捕获机制才返回，如果finally中有return语句，会将其他块中的return的值覆盖
		}
	}
}
