package thread;
/**
 * 适当缩小同步范围可以在保证并发安全的前提下提高代码
 * 并发执行的效率
 * @author JAVA
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				shop.buy();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Shop {
//	public synchronized void buy() {
	public void buy() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName() + ": 正在挑衣服...");
			Thread.sleep(5000);
			/*
			 * synchronized块又称为同步块
			 * 同步快可以更精确地包含需要同步运行的代码片段
			 * 这样做可以有效缩小同步范围提高并发效率。
			 * 语法：
			 * synchronized (同步监视器) {
			 * 		需要同步运行的代码片段...
			 * }
			 * 同步监视器对象可以是java中的任何对象，只要保证
			 * 多个线程看到的该对象是“同一个”，就可以起到同步效果
			 */
			synchronized (this) {
				System.out.println(t.getName() + ": 正在试衣服...");
				Thread.sleep(5000);
			}
			
			System.out.println(t.getName() + ": 结账离开...");
		} catch (Exception e) {
			
		}
	}
}