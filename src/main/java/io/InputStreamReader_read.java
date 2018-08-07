package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流：java.io.InputStreamReader
 * 可以将字节转换为字符.
 * @author JAVA
 *
 */
public class InputStreamReader_read {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		
		int d = -1;  //保存每次读到的字符
		/*
		 * 字符输入流的read()方法是一次读取一个字符。
		 * 但是由于不同的字符集中字符对应的字节长度不同，
		 * 所以read()方法实际读取多少个字节由指定的
		 * 字符集决定。但是读取了该字符后再java内部都是
		 * 用unicode编码保存，所有字符均2个字节。
		 */
		//返回的int值“低16位”有效，unicode编码的字符
		while ((d = isr.read()) != -1) {
			char c = (char) d;
			System.out.print(c);
		}
		
		isr.close();
	}

}
