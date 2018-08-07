package exception;
/**
 * finally块
 * finally块只能定义在异常捕获机制的最后，即：
 * try后面，或者最后一个catch之后.
 * 
 * finally块可以保证其中的代码必定执行.
 * 所以通常会将释放资源等操作放在finally中.
 * @author JAVA
 *
 */
public class Exception_finally {

	public static void main(String[] args) {
		System.out.println("程序开始了");
		
		try {
			String str = "";
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("出错了!");
		} finally {
			System.out.println("finally中的代码执行了!");
		}
		
		System.out.println("程序结束了");
	}

}
