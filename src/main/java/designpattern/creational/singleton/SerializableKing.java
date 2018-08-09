package designpattern.creational.singleton;

import java.io.Serializable;

/**
 * 当单例模式的类实现了序列化接口时,反序列化时会破坏其单例性;
 * 解决办法: 成员变量添加transient关键字, 定义readResolve()方法.
 * @author Administrator
 *
 */
public class SerializableKing implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static SerializableKing king = new SerializableKing();
	
	private transient String name;

	private SerializableKing() {
		
	}
	
	public static SerializableKing getInstance() {
		return king;
	}
	
	/**
	 * 指定反序列化要返回的对象的生成策略
	 * @return
	 */
	private Object readResolve() {
		return king;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
