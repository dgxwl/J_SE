package reflection;

import java.lang.reflect.Method;

/**
 * 调用有参方法
 * @author JAVA
 *
 */
public class Demo4_callMehodWithParas {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("reflection.Person");
		Object obj = cls.newInstance();
		
		//获取有参数的sayHello()方法
		Method method = cls.getDeclaredMethod("sayHello", new Class[]{String.class});
		method.invoke(obj, new Object[]{"张三"});
		
		Method method2 = cls.getDeclaredMethod("sayHello", new Class[]{String.class, int.class});
		method2.invoke(obj, new Object[]{"李四", 16});
	}
}