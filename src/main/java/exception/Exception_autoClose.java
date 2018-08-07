package exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 自JDK1.7之后推出了一个新的特性，auto_close
 * 该特性要求异常捕获机制的结构改变为：
 * try (
 * 	需要使用的流的定义
 * ){
 *	正常的IO操作 
 * } catch (XXException e) {
 * 	捕获特定异常后的解决代码
 * }
 * java中所有的流都实现了closeable接口，在JDK1.7之后该
 * 接口继承了一个新的接口AutoCloseable.那么上述写法可以
 * 将try()中定义的流自动关闭。而无需在finally块中定义
 * 关闭流操作了。
 * @author JAVA
 *
 */
public class Exception_autoClose {

	public static void main(String[] args) {
		try (
				BufferedReader br = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("./src/main/java/exception/Exception_finally3.java")
					)
				);
		){
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
