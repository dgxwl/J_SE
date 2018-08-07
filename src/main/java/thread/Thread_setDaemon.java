package thread;
/**
 * 守护线程
 * 守护线程在使用上与普通线程没有什么区别，但最大的区别
 * 体现在一个结束时机上，即：进程结束。
 * 进程中至少有一个普通线程，若一个进程中所有的普通线程
 * 都结束时，那么该进程就会结束，无论在该进程中是否还有守护
 * 线程运行，它们都会被强制中断.
 * @author JAVA
 *
 */
public class Thread_setDaemon {
	public static void main(String[] args) {
		/*
		 * 前台线程：rose
		 */
		Thread rose = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:啊啊啊啊啊AAAAAAaaaaaaa");
				System.out.println("噗通!");
			}
		};
		
		Thread jack = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("jack:you jump, i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		rose.start();
		
		/*
		 * 设置为守护线程（后台线程）
		 * 需要注意，必须在该线程启动前设置。
		 */
		jack.setDaemon(true);
		jack.start();
		
		System.out.println("main线程执行完了");
//		while (true) {
//			
//		}
	}
}
