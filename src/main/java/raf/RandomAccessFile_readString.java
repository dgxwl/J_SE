package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字符串
 * @author JAVA
 *
 */
public class RandomAccessFile_readString {

	public static void main(String[] args) throws IOException {
		/*
		 * 将raf.txt文件中的字符串读取出来
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "r");
		
		byte[] data = new byte[100];
		
		int len = raf.read(data);
		/*
		 * String提供了构造方法可以将给定的字节数组
		 * 转化为对应的字符串内容
		 */
		String str = new String(data, 0, len, "utf-8");
		System.out.println(str);
		raf.close();
	}

}
