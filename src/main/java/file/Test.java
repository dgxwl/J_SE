package file;

import java.io.File;

/**
 * 删除指定的File表示的文件或目录
 * @author JAVA
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir = new File("a");
//		hier(dir);
//		for (int i = 0; i < count; i++) {
//			delete(dir);
//		}
		delete(dir);
	}

	/**
	 * 将给定的File所表示的文件或目录删除
	 * 老师的
	 * @param f
	 */
	public static void delete(File f) {
		if (f.isDirectory()) {
			File[] subs = f.listFiles();
			for (int i = 0; i < subs.length; i++) {
				File sub = subs[i];
				delete(sub);
			}
		}
		f.delete();
	}
	
//	static int count = 0;
//	/**
//	 * 获取目录层数
//	 * @param f
//	 */
//	public static void hier(File f) {
//		count++;
//		if (f.exists()) {
//			File[] subs = f.listFiles();
//			for (int i = 0; i < subs.length; i++) {
//				if (subs[i].isDirectory()) {
//					hier(subs[i]);
//				}
//			}
//		} else {
//			System.out.println("不存在！");
//		}
//	}
//	
//	/**
//	 * 将给定的File所表示的文件或目录删除
//	 * @param f
//	 */
//	public static void delete(File f) {
//		if (f.exists()) {
//			File[] subs = f.listFiles();
//			for (int i = 0; i < subs.length; i++) {
//				if (subs[i].isDirectory()) {
//					delete(subs[i]);
//				} else {
//					subs[i].delete();
//				}
//			}
//			f.delete();
//			System.out.println("删除了");
//		} else {
//			System.out.println("不存在！");
//		}
//	}
}
