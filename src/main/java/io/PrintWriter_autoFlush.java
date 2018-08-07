package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 简易记事本功能
 * 使用PW实现记事本功能.
 * 程序启动后用户在控制台输入的每行字符串都可以
 * 按行写入到note.txt文件中
 * 当用户输入"exit"，程序退出.
 * @author JAVA
 *
 */
public class PrintWriter_autoFlush {
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(
				new BufferedWriter(
					new OutputStreamWriter(
						new FileOutputStream("note.txt", true)
					)
				)
			);
		Scanner scan = new Scanner(System.in);
		
		String str;
		while (true) {
			System.out.println("请输入内容");
			str = scan.nextLine();
			
			if ("EXIT".equals(str.toUpperCase())) {
				System.out.println("再见.");
				break;
			}
			
			pw.println(str);
		}
		
		pw.close();
		scan.close();
	}
}
