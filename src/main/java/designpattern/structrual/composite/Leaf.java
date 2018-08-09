package designpattern.structrual.composite;

/**
 * 叶节点构件,没有下层
 * @author Administrator
 *
 */
public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void display(int level) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < level; i++) {
			builder.append("-");
		}
		System.out.println(builder.toString() + name);
	}

	@Override
	public void add(Component c) {
		throw new RuntimeException("叶节点不能添加子节点.");
	}

	@Override
	public void remove(Component c) {
		throw new RuntimeException("叶节点没有子节点可移除.");
	}

}
