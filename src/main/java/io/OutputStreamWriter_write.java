package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java中的流按照读写单位分为两类：
 * 字节流，字符流
 * 字符流的读写最小单位是一个字符。
 * 所以字符流只用来读写文本数据。
 * 字符流底层本质还是读写字节，只是字符与字节之间的转换
 * 工作交由字符流完成了，方便了我们读写文本数据的读写工作。
 * 
 * java.io.Reader是所有字符输入流的父类
 * java.io.Writer是所有字符输出流的父类
 * 
 * 常见的实现类之一：转化流
 * java.io.InputStreamReader
 * java.io.OutputStreamWriter
 * 
 * @author JAVA
 *
 */
public class OutputStreamWriter_write {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		
		String str = "我知道，那些夏天，就像青春一样回不来！";
		/*
		 * osw会将给定的字符串按照指定的字符集转换为一组
		 * 字节，然后再通过其连接的流（这里是fos）将这组字节
		 * 写出。
		 */
		osw.write(str);
		System.out.println("写出完毕!");
		osw.close();
	}

}
