package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个新文件
 * @author JAVA
 *
 */
public class File_createNewFile {

	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建一个文件：test.txt
		 * "./"可以不写，不写就是当前目录
		 */
		File file = new File("test.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("文件创建完毕！");
		} else {
			System.out.println("该文件已存在！");
		}
	}

}
