package thread;
/**
 * 线程并发安全问题
 * 多线程并发运行时访问同一资源时，会出现线程之间“抢”的
 * 现象，由于线程切换时机不可控，会导致代码执行顺序未按照
 * 程序设定顺序执行而导致的逻辑混乱。严重时可能导致系统瘫痪。
 * @author JAVA
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					int bean = table.getBean();
					Thread.yield();  //模拟线程没时间而发生切换
					System.out.println(getName() + ": " + bean);
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName() + ": " + bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Table {
	private int beans = 20;
	/**
	 * 当一个方法使用synchronized修饰后，该方法称为
	 * “同步方法”，即：多个线程不能同时进入方法内部执行。
	 * 这样就将多线程并发运行方法改为同步运行。将抢着执行
	 * 改为了顺序执行，这样就不会出现并发安全问题了。
	 * 
	 * 方法上使用synchronized修饰，那么同步监视器
	 * 对象就是这个方法所属对象，即方法中看到的this。
	 * @return
	 */
	public synchronized int getBean() {
		if (beans == 0) {
			throw new RuntimeException("没有豆子了");
		}
		Thread.yield();  //模拟线程没时间而发生切换
		return beans--;
	}
}