package exception;
/**
 * java异常捕获机制中的try-catch
 * 
 * 格式：
 * try {
 * 	代码片段...
 * } catch (XXXException e) {
 * 	捕获了try中出现的XXXException并进行处理的代码片段
 * }
 * @author JAVA
 *
 */
public class Exception_try_catch {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		
		try {
			String str = "a";
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
			/*
			 * try块中出错代码以后的额代码均不再执行
			 */
			System.out.println("!!!!!");
		} catch (NullPointerException e) {
			System.out.println("出现了空指针");
		} catch (StringIndexOutOfBoundsException e) {
			/*
			 * catch可以定义多个，针对try代码块中的代码
			 * 抛出的不同异常可以分别捕获并处理.
			 */
			System.out.println("字符串下标越界了!");
		} catch (Exception e) {
			/*
			 * 应当有一个好习惯，在最后一个catch中捕获
			 * Exception，防止代码出现了一个未知的异常导致
			 * 中断.
			 */
			System.out.println("反正就是出了个错!");
		}
		
		System.out.println("程序结束了");
	}
}
