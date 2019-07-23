package designpattern.creational.singleton;

/**
 * 改进的懒汉式.不存在线程安全问题, 效率高, 推荐使用!
 * 《Effective Java》71条: Lazy initialization holder class模式;
 * 此方式适用于静态成员的延迟初始化.
 *
 */
public class StaticInnerClassKing {

	private StaticInnerClassKing() {
		
	}
	
	static class Holder {
		private static StaticInnerClassKing king = new StaticInnerClassKing();
	}
	
	public static StaticInnerClassKing getInstance() {
		return Holder.king;
	}
}
