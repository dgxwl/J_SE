package schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用Timer类安排执行定时任务.
 * 一个Timer对象对应一个线程,当定时任务结束后,该线程也会终止.
 * Timer不保证实时,使用Object.wait()来安排任务.
 * Timer是线程安全的.
 * @author Administrator
 *
 */
public class TimerDemo {
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		/*
		 * schedule(TimerTask task, long delay, long period)设定任务和开始运行延迟时间和间隔时间.
		 */
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("哈哈" + Thread.currentThread().getName());
//			}
//		}, 0, 1000);
		
		
		Calendar c = Calendar.getInstance();
		c.set(2018, Calendar.AUGUST, 9, 11, 14, 20);
		Date date = c.getTime();
		/*
		 * schedule(TimerTask task, Date firstTime, long period)
		 * 根据设定时间开始进行重复的固定延迟执行;如果设定的时间在启动时间之前,立即开始执行;如果
		 * 某次任务由于某原因延迟了执行,则后续执行也将被延迟.
		 */
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("哈哈" + Thread.currentThread().getName());
			}
		}, date, 1000);
		
		/*
		 * scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
		 * 根据设定的初始执行时间来安排每次执行;如果某次任务由于某原因延迟了执行(或设定的时间在启动时间之前),
		 * 则将快速连续地出现两次或更多的执行,从而使后续执行能够"追赶上来".
		 */
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("呵呵" + Thread.currentThread().getName());
			}
		}, date, 1000);
		
		Thread.sleep(10000);
		
		//终止此定时器,所有已安排的任务都终止,该timer对应的执行线程终止,无法再安排执行任务.
		timer.cancel();
	}
}
