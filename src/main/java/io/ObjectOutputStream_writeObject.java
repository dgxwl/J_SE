package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * 对象流是一对高级流，作用是可以方便地读写java中的
 * 任何对象。
 * 
 * 若将对象流与文件流进行连接，则可以在文件中读写java
 * 中的对象。
 * 
 * java.io.ObjectOutputStream
 * 对象输出流，用于将java对象转换为一组字节后写出
 * 
 * java.io.ObjectInputStream
 * 对象输入流，用于读取一组字节后转换为对应的java对象
 * 前提是该组字节应当是对象输出流将一个对象转换的字节
 * 
 * @author JAVA
 *
 */
public class ObjectOutputStream_writeObject {
	public static void main(String[] args) throws IOException {
		Person person = new Person();
		person.setName("Zhangsan");
		person.setAge(18);
		person.setGender("male");
		String[] otherInfo = {"desc1", "desc2", "desc3"};
		person.setOtherInfo(otherInfo);
		System.out.println(person);
		/*
		 * 将person对象写入文件
		 */
		FileOutputStream fos = new FileOutputStream("person.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * 对象输出流提供的writeObject()方法可以将
		 * 给定的对象转换为一组字节，这里对象流连接
		 * 了文件流，所以转换的这组字节就通过文件流最终写入了文件。
		 * 
		 * oos将对象转换一组字节的过程称为：
		 * 对象序列化
		 * 
		 * 将这组字节通过fos写入文件做长久保存的过程称为：持久化
		 */
		oos.writeObject(person);
		
		System.out.println("写出完毕!");
		oos.close();
	}
}
