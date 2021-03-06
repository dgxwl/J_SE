package designpattern.creational.singleton;

/**
 * 单例模式的懒汉式: 第一次获取实例时才创建对象;
 * 存在线程安全问题, 需要加双层锁.
 * 《Effective Java》71条: 双重检查模式;
 * 其实本来应该用于实例成员变量的延迟初始化
 */
public class LazyKing {
	//添加volatile关键字防止指令重排
	private volatile static LazyKing king = null;
	
	private LazyKing() {
		
	}
	
	public static LazyKing getInstance() {
		LazyKing result = king;  //《Effective Java》说静态变量已初始化时,用这个局部变量可以使得静态变量只读取1次,提升了性能;不懂原理,暂且信了
		//不需要外层if也能实现单例,但每次调用都要锁定操作,比较耗费性能;而且当king实例化后就不必再进入sync语句块了.
		if (result == null) {
			//加锁防止多线程时重复创建对象
			synchronized (LazyKing.class) {
				result = king;
				if (result == null) {
					System.out.println("New instance");
					/*
					 * 经过编译后,下面语句变成3条JVM指令:
					 * memory = allocate();		//1：分配对象的内存空间
					 * ctorInstance(memory);	//2：初始化对象
					 * king = memory;			//3：设置king指向刚分配的内存地址
					 * 有可能被优化成这样的顺序(指令重排):
					 * memory = allocate();		//1：分配对象的内存空间
					 * king = memory;			//3：设置king指向刚分配的内存地址 
					 * ctorInstance(memory);	//2：初始化对象
					 * 当线程A执行完以上第二行,即king指向了分配的内存空间,已不为null,然而没有经过初始化;
					 * 此时若线程B执行了外层if,king不为null,将会得到一个未初始化的对象!
					 * 因此king声明时,需要加上volatile关键字,避免优化.
					 */
					king = result = new LazyKing();
				}
			}
		}
		return result;
	}
}
