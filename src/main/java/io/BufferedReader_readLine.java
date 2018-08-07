package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 缓冲字符输入流
 * java.io.BufferedReader
 * 可以按行读取字符串
 * @author JAVA
 *
 */
public class BufferedReader_readLine {

	public static void main(String[] args) throws IOException {
		/*
		 * 将当前源代码中所有内容输入到控制台
		 * 思路：
		 * 将当前源代码中每行字符串读取出来以后
		 * 通过System.out.println输出到控制台即可
		 */
		FileInputStream fis = new FileInputStream("./src/main/java/io/BufferedReader_readLine.java");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		/*
		 * BufferedReader提供了读取一行字符串的方法：
		 * String readLine()
		 * 该方法会顺序读取若干字符，直到读取了换行符
		 * 为止，然后将换行符之前的字符组成一个字符串
		 * 返回。若返回值为null，说明读取到了末尾.
		 */
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
	}

}
