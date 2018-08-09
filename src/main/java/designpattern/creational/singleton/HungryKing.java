package designpattern.creational.singleton;

/**
 * 单例模式: 某个类仅实例化一次.
 * 饿汉式: 类初始化时即创建对象, 线程安全.
 * @author Administrator
 *
 */
public class HungryKing {
	private static HungryKing king = new HungryKing();
	
	private HungryKing() {
		
	}
	
	public static HungryKing getInstance() {
		return king;
	}
}
