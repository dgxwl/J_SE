package designpattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {
	public static void main(String[] args) throws Exception {
		//饿汉式
		HungryKing hk1 = HungryKing.getInstance();
		HungryKing hk2 = HungryKing.getInstance();
		System.out.println(hk1 == hk2);
		
		//懒汉式
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				LazyKing lk = LazyKing.getInstance();
			}).start();
		}
		
		//序列化与反序列化Singleton
		SerializableKing sk1 = SerializableKing.getInstance();
		sk1.setName("abc");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./sk.dat"));
		oos.writeObject(sk1);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./sk.dat"));
		SerializableKing sk2 = (SerializableKing) ois.readObject();
		System.out.println(sk1 == sk2);
		System.out.println(sk2.getName());
		
		ois.close();
		oos.close();
		
		//静态内部类懒汉式
		StaticInnerClassKing sick1 = StaticInnerClassKing.getInstance();
		StaticInnerClassKing sick2 = StaticInnerClassKing.getInstance();
		System.out.println(sick1 == sick2);
		
		//枚举实现单例
		EnumKing ek1 = EnumKing.INSTANCE;
		EnumKing ek2 = EnumKing.INSTANCE;
		System.out.println(ek1 == ek2);
	}
}
