package designpattern.singleton;

/**
 * 利用枚举实现单例模式;简洁,自带序列化机制,防止多次实例化,且能防御反射攻击.
 * @author Administrator
 *
 */
public enum EnumKing {
	INSTANCE;
	
	private int someField;

	public int getSomeField() {
		return someField;
	}

	public void setSomeField(int someField) {
		this.someField = someField;
	}
	
	
}
