package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF读写基本类型数据。以及RAF基于指针的操作
 */
public class RandomAccessFile_rwInt {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");

		/*
		 * long getFilePointer()
		 * 获取当前RAF的指针位置
		 * RAF在创建出来时默认指向文件第一个字节
		 * 对应的位置为"0"
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:" + pos);  //0
		
		/*
		 * 向文件中写入一个int最大值
		 *                            VVVVVVVV
		 * 01111111 11111111 11111111 11111111
		 * 位运算
		 * imax>>>24
		 */
		int imax = Integer.MAX_VALUE;
		raf.write(imax>>>24);
		System.out.println("pos:" + raf.getFilePointer());  //1
		raf.write(imax>>>16);
		raf.write(imax>>>8);
		raf.write(imax);
		
		raf.writeInt(imax);
		System.out.println("pos:" + raf.getFilePointer());  //8
		
		raf.writeLong(123L);
		
		raf.writeDouble(123.123);
		System.out.println("pos:" + raf.getFilePointer());  //24
		
		System.out.println("写出完毕!");
		
		/*
		 * void seek(long pos)
		 * 移动指针到指定位置
		 */
		//先将指针移动到文件开始
		raf.seek(0);
		System.out.println("pos:" + raf.getFilePointer());
		
		int d = raf.readInt();
		System.out.println(d);
		System.out.println("pos:" + raf.getFilePointer());
		
		raf.seek(8);
		long l = raf.readLong();
		System.out.println(l);
		System.out.println("pos:" + raf.getFilePointer());
		
		double dou = raf.readDouble();
		System.out.println(dou);
		System.out.println("pos:" + raf.getFilePointer());
		
		raf.seek(0);
		long ll = raf.readLong();
		System.out.println(ll);
		System.out.println("pos:" + raf.getFilePointer());
		
		raf.close();
	}

}
