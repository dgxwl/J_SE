package schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 由于Timer是单线程的,同一timer对象下的所有任务都是串行运行,
 * 假如其中一个任务耗时较长,会影响其他任务;为弥补Timer的缺陷,
 * jdk1.5开始提供了支持多线程的ScheduledExecutorService接口,
 * 并在Executors中提供了获取实例的工厂方法.
 * @author Administrator
 *
 */
public class ScheduledExecutorService_demo {
	public static void main(String[] args) {
		/*
		 * Executors.newScheduledThreadPool(int corePoolSize)传入线程数量参数,
		 * 返回一个ScheduledThreadPoolExecutor对象,是线程池类的一个派生类.
		 */
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		/*
		 * scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
		 * 实现Runnable接口定义任务,传入延迟时间,间隔时间,时间单位
		 */
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("haha");
			}
		}, 0, 1, TimeUnit.SECONDS);
	}
}
