package exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * JDK1.7新特性, try...multi-catch
 * @author Administrator
 *
 */
public class Exception_try_multi_catch {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("/a/b.txt");) {
			Thread.sleep(1000);
			//可同时捕获多种异常
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
