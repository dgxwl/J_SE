package thread;

import java.util.Scanner;

/**
 * sleep阻塞
 * 
 * thread提供了一个静态方法：
 * static void sleep(long ms)
 * 该方法可以使运行这个方法的线程阻塞指定毫秒。当超时后
 * 该线程会自动回到RUNNABLE状态等待分配时间片再次并发运行。
 * 
 * 如果一个线程处于阻塞状态，那么它获取CPU时间片后，CPU
 * 会立刻放弃该线程而切换其他线程运行.
 * @author JAVA
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		/*
		 * 编写一个倒计时程序
		 * 程序启动后，要求用户输入一个秒数.
		 * 然后每秒减一输出，减到0为止并输出“到时了”
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个秒数：");
		long s = scan.nextLong();
		
		while (true) {
			if (s < 0) {
				System.out.println("到时了");
				break;
			}
			System.out.println(s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s--;
		}
		
//		while (true) {
//			System.out.println("你好");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		scan.close();
	}
}
