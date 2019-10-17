package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 一个失败的例子
 * 在文件流将新文件写入完毕、但流还没关闭时,用file对象操作这个文件会失败(不报错)
 */
public class Test2 {

	public static void main(String[] args) {
		String path = "D:/note.txt";
		
		try (FileOutputStream fos = new FileOutputStream(path);
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				PrintWriter pw = new PrintWriter(osw, true)) {
			pw.println("text");
			pw.println("text text");
			pw.println("text text text");
			
			//***流操作完了***
			
			//在这用file操作刚刚写出的文件,操作失败!
//			File file = new File(path);
//			System.out.println(file.length());  //得到的文件大小可能是0
//			System.out.println(file.delete());  //删除该文件,返回false,删除失败
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//在这用file操作文件才成功,此时流已经关闭
		File file = new File(path);
		System.out.println(file.length());
		System.out.println(file.delete());
	}
}
