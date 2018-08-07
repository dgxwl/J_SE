package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 练习：
 * 针对user.dat文件完成修改用户功能
 * 
 * 程序启动后，要求用户输入要修改的用户的名字
 * 若有这个人，则要求用户输入新的工资并进行修改
 * 若没有这个人，则显示：查无此人
 * @author JAVA
 *
 */
public class Test5 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		
		System.out.println("请输入用户名：");
		String input = scan.nextLine();
		
		boolean flag = false;
		for (int i = 0; i < raf.length(); i+=70) {
			byte[] data = new byte[32];
			raf.seek(i);
			raf.read(data);
			String name = new String(data, "utf-8");
			if (name.trim().equals(input)) {
				flag = true;
				System.out.println("已查找到，请输入新工资：");
				int newSal = Integer.parseInt(scan.nextLine());
				raf.seek(raf.getFilePointer()+14);
				raf.writeInt(newSal);
				System.out.println("修改成功!");
			}
		}
		if (!flag) {
			System.out.println("查无此人！");
		}
		
		scan.close();
		raf.close();
	}
}
