package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIOCopyDemo01 {

	public static void main(String[] args) throws IOException {
		File src = new File("f1.txt");
		File dest = new File("f2.txt");
		doCopy01(src, dest);
	}

	/**
	 * 将原文件中的内容拷贝到目标文件中
	 * @param src 表示原文件
	 * @param dest 表示目标文件
	 * @throws IOException 
	 */
	static void doCopy01(File src, File dest) throws IOException {
		//1.构建流对象
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dest);
		//2.读写数据
//		int d = -1;
//		while ((d = in.read()) != -1) {
//			out.write(d);
//		}
		byte[] buf = new byte[1024];
		int len = -1;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		System.out.println("复制成功");
		//3.释放资源
		in.close();
		out.close();
	}
}
