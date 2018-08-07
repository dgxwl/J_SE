package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo01 {

	public static void main(String[] args) throws IOException {
		String content = "Hello jsd1710";
		//1.构建输出流对象
		OutputStream out;
		//当FileOutputStream对应的文件不存在会自动创建
//		out = new FileOutputStream("f1.txt");  //每次打开文件，写入数据都会执行覆盖操作
		//假如希望每次打开文件要在原有内容基础上追加内容，
		//可以采用如下构造方法，true表示执行追加操作
		out = new FileOutputStream("f1.txt", true);
		//2.使用输出流对象向文件写数据
		//2.1方式1
//		for (int i = 0; i < content.length(); i++) {
//			char c = content.charAt(i);
//			out.write(c);
//		}
		//2.2方式2
		//读取字符串中的字节存储到数组
		byte[] data = content.getBytes("utf-8");
		//将数组中所有字节写到对应的文件
		out.write(data);
		
		System.out.println("写入完毕！");
		//3.释放资源
		out.close();
	}

}
