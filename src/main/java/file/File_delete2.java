package file;

import java.io.File;

/**
 * 删除一个目录
 * @author JAVA
 *
 */
public class File_delete2 {

	public static void main(String[] args) {
		/*
		 * 删除当前目录中的test目录
		 * delete()方法在删除目录时要求该目录必须是一个空目录,否则是不能删除的.
		 */
		File dir = new File("test");
		if (dir.exists()) {
			dir.delete();
			System.out.println("删除完毕！");
		} else {
			System.out.println("该目录不存在！");
		}
	}

}
