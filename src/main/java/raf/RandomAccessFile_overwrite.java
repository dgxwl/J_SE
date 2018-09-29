package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 覆盖或追加写操作
 * @author JAVA
 *
 */
public class RandomAccessFile_overwrite {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		/*
		 * 指针默认在文件开始，若直接写，会将该文件这段
		 * 数据覆盖掉
		 */
//		byte[] data = "漫天星光".getBytes("UTF-8");
//		raf.write(data);
		
		/*
		 * 若希望在文件末尾追加写，需要先将指针移动到
		 * 文件最后
		 */
		raf.seek(raf.length());
		raf.write("满天星光只因我而闪烁.".getBytes("UTF-8"));
		System.out.println("写出完毕!");
		
		raf.close();
	}

}
