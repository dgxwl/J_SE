package thread;
/**
 * 获取线程相关信息的方法
 * @author JAVA
 *
 */
public class Thread_info {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		
		String name = main.getName();
		System.out.println(name);
		
		//id:唯一标识
		long id = main.getId();
		System.out.println("id：" + id);
		
		//优先级
		int priority = main.getPriority();
		System.out.println("优先级：" + priority);
		
		
		boolean isAlive = main.isAlive();
		System.out.println("isAlive：" + isAlive);
		
		//是否为守护线程
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemon：" + isDaemon);
		
		//是否被中断
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted：" + isInterrupted);
	}
}
