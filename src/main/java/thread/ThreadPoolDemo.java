package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要解决两个问题:
 * 1:控制线程数量
 * 2:重用线程
 * 频繁地创建销毁线程会给系统带来不必要的开销.应当重用.
 * 创建过多的线程会使得系统资源过大,CPU过度切换而拖慢并发
 * 执行效率.严重时可能会导致系统瘫痪.所有要控制线程数量.
 * @author JAVA
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 5; i++) {
			Runnable runn = new Runnable() {
				@Override
				public void run() {
					try {
						Thread t = Thread.currentThread();
						System.out.println(t.getName() + "正在执行");
						Thread.sleep(5000);
						System.out.println(t.getName() + "运行完毕");
					} catch (InterruptedException e) {
						System.out.println("线程被中断了!");
					}
				}
			};
			//将任务指派给线程池
			threadPool.execute(runn);
			System.out.println("将任务" + i + "交给了线程池");
		}
		
		//所有任务执行完时关闭线程池
		threadPool.shutdown();
		//执行此方法立即关闭线程池
//		threadPool.shutdownNow();
		System.out.println("关闭了线程池.");
	}
}
