package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 其中一种构件
 * @author Administrator
 *
 */
public class Composite extends Component {
	
	List<Component> list;

	public Composite(String name) {
		super(name);
		list = new ArrayList<>();
	}

	@Override
	public void display(int level) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < level; i++) {
			builder.append("-");
		}
		System.out.println(builder.toString() + name);
		//递归
		for (Component c : list) {
			c.display(level + 1);
		}
	}
	
	/**
	 * 添加构件
	 * @param c
	 */
	public void add(Component c) {
		list.add(c);
	}
	
	/**
	 * 删除构件
	 * @param c
	 */
	public void remove(Component c) {
		list.remove(c);
	}
	
}
