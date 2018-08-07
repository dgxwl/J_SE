package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo01 {

	public static void main(String[] args) throws IOException {
		//1.构建输入流对象
		InputStream in = new FileInputStream("f1.txt");
		
		//2.读数据
		//2.1方法1
//		do {
//			int c = in.read();  //一次读取一个字节
//			if (c==-1) break;  //read方法读到文件尾，返回值为-1
//			System.out.print((char) c);
//		} while (true);
		//2.2方法2
		byte[] buf = new byte[256];
		do {
			int len = in.read(buf);  //将数据读到buf数组中，一次最多读256个字符；返回值len为读取的字节的个数
			if (len==-1) break;  //判定是否已经读到文件尾，读到文件尾则退出
			String s = new String(buf, 0, len);  //将读取到的内容转换为字符串，读多少转多少
			System.out.print(s);
		} while (true);
		
		//3.释放资源
		in.close();
	}

}
