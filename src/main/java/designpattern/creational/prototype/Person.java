package designpattern.creational.prototype;

import lombok.Data;

/**
 * 对象的浅克隆需要实现Cloneable接口, 否则调用clone()抛异常;
 * 浅克隆只复制对象的基本类型属性和引用属性的值(即指向对象是同一个).
 * @author Administrator
 *
 */
@Data
public class Person implements Cloneable {
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	//重写clone()方法
	@Override
	protected Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}
}
