package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 动态调用方法
 * @author JAVA
 *
 */
public class Demo2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要实例化的类:");
		String className = scan.nextLine();
		
		System.out.println("请输入要调用的方法:");
		String methodName = scan.nextLine();
		
		Class cls = Class.forName(className);
		//实例化
		Object p = cls.newInstance();
		/*
		 * Class获取其表示的类的方法:
		 * Method getDeclaredMethod(methodName, Class[] args)
		 * 
		 * Method类的每个实例用于表示一个类的方法.
		 * 常用方法:invoke()
		 * 参数1:指定调用哪个对象的该方法
		 * 参数2:该方法需要传入的实际参数
		 */
		Method method = cls.getDeclaredMethod(methodName, null);	
		method.invoke(p, null);
	}
}
