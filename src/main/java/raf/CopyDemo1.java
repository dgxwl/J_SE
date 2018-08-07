package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author JAVA
 *
 */
public class CopyDemo1 {

	public static void main(String[] args) throws IOException {
		/*
		 * 思路
		 * 将源文件的每个字节顺序地读取出来并且
		 * 写入到另一个文件中
		 */
		RandomAccessFile src = new RandomAccessFile("周杰伦 - 花海.mp3", "r");
		RandomAccessFile desc = new RandomAccessFile("周杰伦 - 花海_cp.mp3", "rw");
		
		int d = -1;  //用来保存每次读取的字节
		
		long start = System.currentTimeMillis();
		
		while ((d = src.read()) != -1) {
			desc.write(d);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("复制完毕，耗时：" + (end-start) + "ms");
		
		src.close();
		desc.close();
	}

}
