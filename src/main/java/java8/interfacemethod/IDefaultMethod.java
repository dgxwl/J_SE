package java8.interfacemethod;

/**
 * Java8在接口中可定义含有实现的默认方法
 * @author Administrator
 *
 */
public interface IDefaultMethod {
	
	//通过default关键字定义默认方法
	default void defaultMethod() {
		System.out.println("This is a default method.");
	}
	
	//在接口中可以定义静态方法
	public static void staticMethod() {
		System.out.println("This is a static method.");
	}
	
	//Illegal modifier for the interface method staticsMethod; only public, abstract, default, static and strictfp are permitted
//	private static void staticsMethod() {  //error
//		System.out.println("This is a static method.");
//	}
}
