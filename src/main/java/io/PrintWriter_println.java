package io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * java.io.BufferedWriter
 * java.io.BufferedReader
 * 缓冲字符流读写字符串效率高，并且可以按行读写字符串。
 * 
 * java.io.PrintWriter:具有自动行刷新的缓冲字符输出流
 * 其内部的缓冲操作就是靠BufferedWriter完成的。所以
 * PW总是会连接在BW上
 * @author JAVA
 *
 */
public class PrintWriter_println {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * 向文件中按行写入字符串
		 */
//		PrintWriter pw = new PrintWriter("pw.txt");
		
		//流连接形式创建
		PrintWriter pw = new PrintWriter(
			new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream("pw.txt")
				)
			)
		);
		
		pw.println("让我再看你一遍，从南到北.");
		pw.print("像是北五环路蒙住的双眼.");
		
		System.out.println("写出完毕!");
		pw.close();
	}

}
