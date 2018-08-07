package thread;
/**
 * 互斥锁
 * 当synchronized修饰多段代码，但是同步监视器对象是同一个
 * 的时候，这些代码之间就是互斥的，多个线程不能同时执行这几段
 * 代码。
 * @author JAVA
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		Foo foo = new Foo();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				foo.methodA();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				foo.methodB();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Foo {
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + ": 正在运行A方法...");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		System.out.println(t.getName() + ": A方法运行完毕...");
	}
	
	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + ": 正在运行B方法...");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		System.out.println(t.getName() + ": B方法运行完毕...");
	}
}