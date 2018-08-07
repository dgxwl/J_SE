package designpattern.singleton;

/**
 * 改进的懒汉式.不存在线程安全问题, 效率高, 推荐使用!
 * @author Administrator
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
