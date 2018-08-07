package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 用当前类测试对象流的对象读写操作
 * 
 * 若希望被对象流进行读写，name当前类必须实现可序列化接口:
 * java.io.Serializable
 * 
 * 签名接口
 * @author JAVA
 *
 */
public class Person implements Serializable {
	/**
	 * 当一个类实现了Serializable接口后，应当添加
	 * 一个常量：serialVersionUID，序列化版本号
	 * 序列化版本号影响对象输入流在反序列化对象时的结果。
	 * 当反序列化的对象与所属类现在的版本号不一致时
	 * 反序列化会失败，抛出：InvalidClassException
	 * 若版本号没有发生改变，是可以反序列化成功的。哪怕
	 * 当前类的结果与待发序列化的对象结构不符。但若不符
	 * 则采取的原则是还原已有的属性。没有的则忽略了。
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * 当一个属性被transient关键字修饰后，这个对象
	 * 在序列化时该属性值会被忽略。忽略不需要序列化
	 * 的属性可以达到“对象”瘦身的效果.
	 */
	private transient String[] otherInfo;
	
	public Person() {
		
	}

	public Person(String name, int age, String gender, String[] otherInfo) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String[] otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	@Override
	public String toString() {
		return name + ", " + age + ", " + gender + ", " + Arrays.toString(otherInfo);
	}
}
