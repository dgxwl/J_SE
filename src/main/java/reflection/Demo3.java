package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射机制访问私有方法
 * @author JAVA
 *
 */
public class Demo3 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
//		Person p = new Person();
//		p.say();  //传统方式是无法再Person外部访问私有方法的
		
		Class cls = Class.forName("reflection.Person");
		Object obj = cls.newInstance();
		Method method = cls.getDeclaredMethod("say", null);
		/*
		 * 强制设置允许访问该私有方法,访问私有方法前若不进行设置,name调用invoke()时会抛出权限不足的异常.
		 * 但是需要注意,这样做违背了java面向对象中的封装性,实际开发中要谨慎使用.
		 */
		method.setAccessible(true);
		method.invoke(obj, null);
	}
}
