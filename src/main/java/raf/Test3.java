package raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成用户注册功能
 * 
 * 程序启动后，要求用户顺序输入：
 * 用户名，年龄，工资，性别，入职日期
 * 例如：
 * 张三
 * 25
 * 3000
 * 男
 * 2017-12-21
 * 然后将该用户写入文件user.dat.
 * 
 * 其中名字，性别，入职日期为字符串，年龄和工资为int值.
 * @author JAVA
 *
 */
public class Test3 {

	public static void main(String[] args) throws IOException {
		/*
		 * 规定每条记录固定占70个字节
		 * name 32
		 * age 4
		 * gender 10
		 * salary4
		 * hiredate 20
		 */
		Scanner scan  =new Scanner(System.in);
		System.out.println("请输入注册信息：");
		System.out.println("请输入用户名：");
		String name = scan.nextLine();
		
		System.out.println("请输入年龄：");
		int age = Integer.parseInt(scan.nextLine());
		
		System.out.println("请输入性别：");
		String gender = scan.nextLine();
		
		System.out.println("请输入工资：");
		int salary = Integer.parseInt(scan.nextLine());
		
		System.out.println("请输入入职日期：");
		String hireDate = scan.nextLine();
		
		System.out.println(name + ", " + age + ", " + gender + ", " + salary + ", " + hireDate);
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		//先将指针移动到文件末尾
		raf.seek(raf.length());
		
		//写入名字 32字节
		byte[] nameData = name.getBytes("utf-8");
		//将名字的字节数组扩容到10字节
		nameData = Arrays.copyOf(nameData, 32);
		raf.write(nameData);
		System.out.println("名字写入完毕，指针位置：" + raf.getFilePointer());
		
		//写入年龄 int值固定4个字节
		raf.writeInt(age);
		System.out.println("年龄写入完毕，指针位置：" + raf.getFilePointer());
		
		//写入性别 10个字节
		byte[] genderData = gender.getBytes("utf-8");
		genderData = Arrays.copyOf(genderData, 10);
		raf.write(genderData);
		System.out.println("性别写入完毕，指针位置：" + raf.getFilePointer());
		
		//写入工资
		raf.writeInt(salary);
		System.out.println("工资写入完毕，指针位置：" + raf.getFilePointer());
		
		//写入入职日期 20字节
		byte[] hireDateData = hireDate.getBytes("utf-8");
		hireDateData = Arrays.copyOf(hireDateData, 20);
		raf.write(hireDateData);
		System.out.println("入职日期写入完毕，指针位置：" + raf.getFilePointer());
		
		System.out.println("注册完毕!");
		System.out.println("指针位置：" + raf.getFilePointer());
		
		raf.close();
		scan.close();
	}

}
