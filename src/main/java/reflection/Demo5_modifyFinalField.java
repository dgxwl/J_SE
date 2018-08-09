package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射修改成员属性和常量
 * @author Administrator
 *
 */
public class Demo5_modifyFinalField {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("reflection.Person");
		Person p = (Person) cls.newInstance();
		
		/*
		 * getDeclaredField(String name)
		 * 根据属性名获取该属性对象
		 */
		Field field = cls.getDeclaredField("weight");
		field.setAccessible(true);
		
		/*
		 * set(Object obj, Object value)
		 * 传入需要改属性的对象和需要修改的新值
		 */
		field.set(p, 70);
		/*
		 * get(Object obj)
		 * 获取传入对象的属性值
		 */
		System.out.println(field.get(p));
		
		//**************修改常量:可修改的常量必须为包装类(什么鬼)******************
		Field f1 = cls.getDeclaredField("HEIGHT");
		f1.setAccessible(true);
		/* 去掉final */
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(f1, f1.getModifiers() & ~Modifier.FINAL);
		//修改常量值
		f1.set(null, 175);
		System.out.println(Person.HEIGHT);
	}
}
