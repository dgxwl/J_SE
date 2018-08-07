package file;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 * @author JAVA
 *
 */
public class File_listFiles {

	public static void main(String[] args) {
		/*
		 * 获取当前目录中的所有内容
		 */
		File dir = new File(".");  //当前目录(本源码根目录)
		
		/*
		 * dir.isFile():判断当前File表示的是否为文件
		 * dir.isDirectory():判断是否为目录
		 */
		if (dir.isDirectory()) {
			File[] subs = dir.listFiles();
			System.out.println(subs.length);
			for (int i = 0; i < subs.length; i++) {
				System.out.println(subs[i].getName());
			}
		}
		
	}

}
