package raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取user.dat文件，将所有注册用户输出到控制台
 * 每行格式：
 * name, age, gender, salary, hiredate
 * 例如：
 * 张三，22，男，3000，2017-05-21
 * @author JAVA
 *
 */
public class Test4 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("user.dat", "r");
		
		long num = raf.length() / 70;
		System.out.println(num + "个用户：");
		
		for (int i = 0; i < num; i++) {
			String name = readString(raf, 32);
			
			int age = raf.readInt();
			
			String gender = readString(raf, 10);
			
			int salary = raf.readInt();
			
			String date = readString(raf, 20);
			
			System.out.println(name + ", " + age + ", " + gender + ", " + salary + ", " + date);
		}
		
		raf.close();
	}

	public static String readString(RandomAccessFile raf, int len) throws IOException {
		byte[] data = new byte[len];
		raf.read(data);
		return new String(data, "utf-8").trim();
	}
}
