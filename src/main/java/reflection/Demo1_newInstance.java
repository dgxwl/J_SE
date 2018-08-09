package reflection;
/**
 * java 反射机制
 * java反射机制是一个动态机制,允许程序运行过程中获取一个
 * 类的信息(属性,方法),并且实例化实例,调用属性方法等.
 * 
 * 使用反射机制可以不再将类与类之间的连接基于源代码在编码
 * 阶段建立.而是在代码运行期建立,大大地提高了代码的灵活度.
 * 但是使用不当会带来性能损耗大等问题.
 * @author JAVA
 *
 */
public class Demo1_newInstance {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*
		 * 传统编写代码时在编码阶段确定类,以及实例化对象并调用方法
		 */
		Person p = new Person();
		p.sayHello();
		
		/*
		 * 反射机制允许在运行期间加载类并动态实例化对象调用方法.
		 * 
		 * Class类
		 * Class类的每一个实例用于描述一个类的所有信息
		 * JVM在加载每个类时都会实例化一个Class的实例
		 * 用于记录该类的信息.
		 * 通过Class可以获取其表示的类的属性,方法,构造方法,类名
		 * 等等信息.并且可以动态实例化该类.
		 * 每个被JVM加载的类都会有且只有一个Class的实例用于记录其信息.
		 * 获取一个类的Class常用方式:
		 * 1:Class.forName(String name)
		 * 2:类名.class(每个类都有一个静态属性class)
		 * 3:使用类加载器加载
		 */
		String name = "reflection.Person";
		Class<?> cls = Class.forName(name);
		Person obj = (Person) cls.newInstance();
		obj.sayHello();
	}
}
