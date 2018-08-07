package thread;
/**
 * 第二种创建线程的方式
 * 实现Runnable接口，单独定义线程任务
 * @author JAVA
 *
 */
public class ThreadDemo2 {

	public static void main(String[] args) {
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

}

class MyRunnable1 implements Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("你系乜谁?");
		}
	}
}

class MyRunnable2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我系查水表尐!");
		}
	}
}