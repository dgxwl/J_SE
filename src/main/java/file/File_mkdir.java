package file;

import java.io.File;

/**
 * 使用File创建一个目录
 * @author JAVA
 *
 */
public class File_mkdir {

	public static void main(String[] args) {
		/*
		 * 在当前目录下创建一个目录test
		 */
		File dir = new File("test");
		if (!dir.exists()) {
			dir.mkdir();
			System.out.println("创建完毕！");
		} else {
			System.out.println("该目录已存在！");
		}
	}

}
