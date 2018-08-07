package thread;
/**
 * 线程的创建有两种方式
 * 第一种创建方式：继承Thread并重写run()方法.
 * @author JAVA
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程要调用start()而不是run()方法。
		 * 当start()方法调用完毕后，线程处于RUNNABLE状态
		 * 一旦分配CPU时间片后，该线程会自行调用run()方法
		 * 开始执行任务。
		 * 
		 * 线程对于线程调度的工作是不可控的：不能主动获取CPU
		 * 时间片，也不能控制时间片的长度，只能被动地被分配
		 * 时间片并发运行.
		 */
		t1.start();
		t2.start();
	}
}
/**
 * 第一种创建线程的方式有两个不足：
 * 1：由于java是单继承的，这就导致了若继承了Thread就不能
 * 再继承其他类去复用方法，这在实际开发中会有诸多不便。
 * 
 * 2.继承线程后重写run()方法来定义该线程要执行的任务，这就
 * 导致了线程与线程要执行的任务有一个必然的耦合关系，这样做
 * 不利于线程的重用.
 * @author JAVA
 *
 */
class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("你是谁啊?");
		}
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的!");
		}
	}
}