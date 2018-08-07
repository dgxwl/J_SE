package lambda;
/**
 * Lambda表达式
 * 
 * @author JAVA
 *
 */
public class LambdaDemo2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("你是谁啊?");
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("我是查水表的!");
			}
		});
		
		t1.start();
		t2.start();
	}
}
