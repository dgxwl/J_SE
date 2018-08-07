package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 向文件中写入字符串
 * @author JAVA
 *
 */
public class RandomAccessFile_writeString {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		/*
		 * GBK 中文每个字符占用2字节
		 * UTF-8 万国码 中文每个字符占3字节
		 * ISO8859-1欧洲字符集 不支持中文
		 */
		String str = "故事开始在最初的那个梦中.";
		
		byte[] data = str.getBytes("utf-8");
		
		raf.write(data);
		System.out.println("写出完毕!");
		
		raf.close();
	}

}
