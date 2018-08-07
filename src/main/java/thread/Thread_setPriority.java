package thread;
/**
 * 线程的优先级
 * 线程优先级有10个等级，分别用整数1-10表示。
 * 其中1为最低优先级，5为默认值，10为最高优先级
 * 
 * 理论上优先级越高的线程获取CPU时间片的次数越多.
 * @author JAVA
 *
 */
public class Thread_setPriority {

	public static void main(String[] args) {
		Thread max = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("max");
				}
			}
		};
		
		Thread norm = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("norm");
				}
			}
		};
		
		Thread min = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("min");
				}
			}
		};
		
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		
		max.start();
		norm.start();
		min.start();
	}

}
