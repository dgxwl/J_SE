package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferIOCopyDemo01 {

	public static void main(String[] args) throws IOException {
		File src = new File("f1.txt");
		File dest = new File("ff2.txt");
		doCopy(src, dest);
	}

	public static void doCopy(File src, File dest) throws IOException {
		// 1.构建流对象（第一看类型，第二看构造方法）
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		
		// 2.读写数据
		byte[] array = new byte[1024];
		int len;
		do {
			len = bis.read(array); // file-->buffer-->array
			if ((len == -1))
				break;
			bos.write(array, 0, len); // array-->buffer-->file
		} while (true);

		bos.flush(); // 循环退出后可能缓冲区还有数据，建议操作结束后刷新缓冲区
		System.out.println("复制成功!");

		// 3.释放资源
		bis.close();
		bos.close(); // 关闭时会自动刷新缓冲区
	}
}
