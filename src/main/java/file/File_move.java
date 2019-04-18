package file;

import java.io.File;

/**
 * 移动文件
 * @author Administrator
 *
 */
public class File_move {
	public static void main(String[] args) {
		File src = new File("./a/abc.text");
		File destPath = new File("./b/");
		if (!destPath.exists()) {
			destPath.mkdir();
		}
		
		/*
		 * boolean renameTo(File dest)
		 * 移动文件到指定的目标File, 返回操作结果(是否成功)
		 */
		boolean succeed = src.renameTo(new File("./b/" + src.getName()));
		if (succeed) {
			System.out.println("移动成功");
		} else {
			System.out.println("移动失败");
		}
	}
}
