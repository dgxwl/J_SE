package file;

import java.io.File;
import java.io.FileFilter;

public class File_listFiles2 {

	public static void main(String[] args) {
		/*
		 * 获取当前目录中名字以"."开头的子项
		 */
		File dir = new File(".");
		File[] subs = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				String name = file.getName();
				System.out.println("正在过滤:" + name);
				return name.startsWith(".");
			}
		});
		
		for (int i = 0; i < subs.length; i++) {
			File sub = subs[i];
			System.out.println(sub.getName());
		}
	}

}
