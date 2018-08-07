package file;

import java.io.File;

/**
 * java.io.File
 * File用来表示文件系统中的一个文件或目录
 * 使用File可以：
 * 1：访问文件或目录的属性（名字、大小等信息）
 * 2:创建或删除文件、目录
 * 3：访问一个目录中的所有子项
 * 
 * 但是File不能用于访问文件数据
 * @author JAVA
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		/*
		 * 路径通常都使用相对路径。
		 * 对于在eclipse中运行程序时，当前目录表示的
		 * 是当前类所在项目的根目录.
		 */
		File file = new File("." + File.separator + "demo.txt");
		String name = file.getName();
		System.out.println(name);
		
		long length = file.length();
		System.out.println(length + "字节");
		
		//可读, 可写
		boolean cr = file.canRead();
		boolean cw = file.canWrite();
		System.out.println("可读：" + cr);
		System.out.println("可写：" + cw);
		
		boolean isHidden = file.isHidden();
		System.out.println("是否隐藏：" + isHidden);
	}

}
