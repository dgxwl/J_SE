package thread;
/**
 * 静态方法上使用synchronized修饰后，该方法一定具有同步效果。
 * @author JAVA
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				Boo.dosome();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				Boo.dosome();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Boo {
	public synchronized static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + ": 正在执行dosome...");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		System.out.println(t.getName() + ": 执行dosome方法完毕!");
	}
}