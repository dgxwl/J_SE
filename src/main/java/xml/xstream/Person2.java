package xml.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 使用@XStreamAlias注解对类名或属性名取别名
 * @author Administrator
 *
 */
@XStreamAlias("root")
public class Person2 {
	@XStreamAlias("id")
	private int id;
	@XStreamAlias("NAME")
	private String name;
	
	public Person2(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
