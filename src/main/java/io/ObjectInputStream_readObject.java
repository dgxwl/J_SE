package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流，用于完成对象反序列化
 * @author JAVA
 *
 */
public class ObjectInputStream_readObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("person.obj");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		/*
		 * 对象输入流在读取一组字节后将其还原为对象
		 * 的过程称为：对象反序列化
		 */
		Person person = (Person) ois.readObject();
		
		System.out.println(person);
		
		ois.close();
	}
}
