package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 完成建议记事本功能
 * 程序开始后，要求用户输入一个文件名，然后对该文件
 * 写操作。
 * 用户之后输入的每一行字符串都要写入该文件。当用户
 * 输入exit时，程序退出
 * @author JAVA
 *
 */
public class Test2 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入文件名：");
		String fileName = scan.nextLine();
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		
		String line = null;
		while (true) {
			System.out.println("请输入：");
			line = scan.nextLine();
			
			if ("EXIT".equals(line.toUpperCase())) {
				System.out.println("程序退出");
				break;
			}
			
			byte[] data = line.getBytes("utf-8");
			
			raf.seek(raf.length());  //将指针移到文件末尾
			
			raf.write(data);
		}
		
		raf.close();
		scan.close();
	}

}
