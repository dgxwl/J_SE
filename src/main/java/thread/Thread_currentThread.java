package thread;
/**
 * Thread提供了一个静态方法
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的当前线程
 * @author JAVA
 *
 */
public class Thread_currentThread {

	public static void main(String[] args) {
		//获取运行main()方法的线程
		Thread main = Thread.currentThread();
		System.out.println("运行main()方法的线程是：" + main);
		dosome();
		
		//自定义线程
		Thread t = new Thread() {
			public void run() {
				/*
				 * ThreadLocal
				 * Spring	IOC  AOP
				 */
				Thread t = Thread.currentThread();
				System.out.println("自定义线程：" + t);
				dosome();
			}
		};
		t.start();
	}

	public static void dosome() {
		//运行dosome()方法的线程
		Thread t = Thread.currentThread();
		System.out.println("运行dosome()方法的线程是：" + t);
	}
}
