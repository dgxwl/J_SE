package raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 用来读写文件数据的类
 * RAF是基于指针进行读写数据的，即：总是在指针位置读写
 * 字节.
 * 指针：指向文件中具体字节的位置
 * @author JAVA
 *
 */
public class RandomAccessFile_write {

	public static void main(String[] args) throws IOException {
		/*
		 * 对当前目录中的raf.dat文件写操作
		 * RAF的常用构造方法：
		 * RandomAccessFile(String path, String mode)
		 * RandomAccessFile(File file, String mode)
		 * 第一个参数是要进行读写的文件，第二个参数
		 * 为模式，支持：
		 * "r"只读模式
		 * "rw"读写模式
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		/*
		 * void write(int d)
		 * 写一个字节，将给定的int值对应二进制的"
		 * 低八位"写入文件
		 * 							  vvvvvvvv
		 * 00000000 00000000 00000000 00000001
		 */
		raf.write(1);
		raf.write(2);
		raf.write(-1);
		raf.write(256);
		
		System.out.println("写出完毕!");
		
		raf.close();
	}

}
