package thread;
/**
 * 使用匿名内部类的形式完成线程两种方式的创建
 * 
 * @author JAVA
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		
		//使用方式1：继承线程重写run()方法形式输出“你是谁”
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("你是谁?");
				}
			}
		};
		
		//使用方式2：使用Runnable完成输出“我是查水表的”
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("我是查水表的!");
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
