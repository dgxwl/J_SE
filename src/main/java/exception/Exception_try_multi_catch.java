package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * JDK1.7新特性, try...multi-catch
 * @author Administrator
 *
 */
public class Exception_try_multi_catch {
	public static void main(String[] args) {
		try {
			Thread.sleep(1000);
			FileInputStream fis = new FileInputStream("/a/b.txt");
			//可同时捕获多种异常
		} catch (FileNotFoundException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
