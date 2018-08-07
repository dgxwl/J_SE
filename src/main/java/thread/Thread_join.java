package thread;
/**
 * void join()
 * join()方法可以让运行该方法的线程在该方法所属线程后面等待
 * 直到方法所属线程运行完毕，才会解除阻塞。
 * join()方法的意义是可以协调线程间同步运行
 * 
 * 同步运行：执行代码有先后顺序。
 * 异步运行：执行各自代码没有先后顺序。
 * 
 * 多线程并发运行代码时就是异步运行的。而如果要求多个线程
 * “排队先后执行各自代码”的情况就是同步运行。
 * @author JAVA
 *
 */
public class Thread_join {
	//图片是否下载完毕的状态
	public static boolean isFinish;
	
	public static void main(String[] args) {
		/*
		 * JDK1.7之前有一个要求。
		 * 即：当一个方法（这里以main()方法为例）的局部内部类（show）
		 * 中若想引用该方法（main()方法）的其他局部变量（download）
		 * 时，那么该变量必须是final的
		 */
		final Thread download = new Thread() {
			@Override
			public void run() {
				System.out.println("down:开始下载图片...");
				for (int i = 0; i < 100; i++) {
					System.out.println(i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down:图片下载完毕!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread() {
			@Override
			public void run() {
				System.out.println("show:准备显示图片...");
				
				/*
				 * 先等download执行完毕
				 * 
				 * show线程调用了download的join()方法后
				 * 会进入阻塞状态，直到download线程方法结束
				 * 才会解除阻塞。
				 */
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (!isFinish) {
					throw new RuntimeException("图片显示失败!");
				}
				System.out.println("show:图片已显示!");
			}
		};
		
		download.start();
		show.start();
	}

}
