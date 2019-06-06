package io;

import java.io.FileInputStream;

/**
 * InputStream转换为byte[] 
 * @author Administrator
 *
 */
public class InputStreamToByteDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./src/main/java/io/InputStreamToByteDemo.java");
		
		/*
		 * int available() 返回可以从此输入流中读取(跳过)的剩余字节数的估计值
		 */
		byte[] fileBytes = new byte[fis.available()];
		fis.read(fileBytes);
		
		System.out.println(new String(fileBytes));
		
		fis.close();
	}
}
