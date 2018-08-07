package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件数据
 * @author JAVA
 *
 */
public class RandomAccessFile_read {

	public static void main(String[] args) throws IOException {
		/*
		 * raf.dat文件中的第一个字节读取出来
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		/*
		 * int read()
		 * 读取1个字节，并将该字节以int形式返回。
		 * 若返回值为-1，则表示读取到了文件末尾。
		 * 00000000 00000000 00000000 00000001
		 */
		int d = raf.read();
		System.out.println(d);
		
		d = raf.read();
		System.out.println(d);
		
		d = raf.read();
		System.out.println(d);
		
		d = raf.read();
		System.out.println(d);
		
		raf.close();
	}

}
