package file;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * 自制文件管理工具可用的知识储备
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		/*
		 * FileSystemView类可用于操作系统的文件系统信息
		 * FileSystemView getFileSystemView() 根据当前操作系统类型返回FileSystemView实例
		 * 可能的具体实现类:
		 * WindowsFileSystemView Windows系统
		 * UnixFileSystemView Unix系统(unix-isms)
		 * GenericFileSystemView 其他系统(未确定)
		 */
		FileSystemView systemView = FileSystemView.getFileSystemView();
		/*
		 * File[] listRoots() 获取所有文件系统根
		 */
		File[] roots = File.listRoots();
		
		for (int i = 0; i < roots.length; i++) {
			//File类 String getPath()   获取file的绝对路径
			System.out.println("根目录: " + roots[i].getPath()
					//FileSystemView类 String getSystemDisplayName(File f) 在系统文件浏览器中显示的展示名称
					+ "\t显示名称: " + systemView.getSystemDisplayName(roots[i])
					//FileSystemView类 String getSystemTypeDescription(File f) 在系统文件浏览器中显示的类型描述
					+ "\t类型: " + systemView.getSystemTypeDescription(roots[i]));
		}
		
		//其余常用方法可查阅JDK API文档
	}
}
