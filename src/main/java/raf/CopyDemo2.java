package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 提高依次读写的数据量减少实际读写次数可提高读写效率
 * 
 * @author JAVA
 *
 */
public class CopyDemo2 {

	public static void main(String[] args) throws IOException {
		/*
		 * 思路 将原文件中的每个字节顺序地读取出来并且 写入到另一个文件中
		 */
		RandomAccessFile src = new RandomAccessFile("周杰伦 - 花海.mp3", "r");
		RandomAccessFile desc = new RandomAccessFile("周杰伦 - 花海_cp2.mp3", "rw");

		/*
		 * int read(byte[] data) 连续读取给定字节数组总长度的字节量，并将 读取到的字节顺序地存入到该字节数组中。
		 * 返回值为实际读取到的字节量。 
		 * 若返回值为-1，说明本次没有读取到任何字节（这里
		 * 是文件末尾）
		 */
		byte[] data = new byte[1024 * 10];  //10kB
		int len = -1;  //记录每次实际读取的字节数

		long start = System.currentTimeMillis();

		while ((len = src.read(data)) != -1) {
			/*
			 * void write(byte[] data)
			 * 将给定的字节数组中的所有字节一次性写入
			 * 到文件中
			 */
			desc.write(data, 0, len);
		}

		long end = System.currentTimeMillis();

		System.out.println("复制完毕，耗时：" + (end - start) + "ms");

		src.close();
		desc.close();
	}

}
