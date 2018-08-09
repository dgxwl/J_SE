package designpattern.structrual.composite;

/**
 * 组合模式中的抽象构件
 * @author Administrator
 *
 */
public abstract class Component {
	
	protected String name;

	public Component(String name) {
		this.name = name;
	}

	/**
	 * 操作构件
	 * @param level
	 */
	public abstract void display(int level);
	
/*
 * 在透明组合模式(标准形式)中,以下2个方法定义在抽象构件中,可以使枝、叶节点具有相同外观; 
 * 但是由于叶节点没有子节点,实现add()和remove()是没有意义的,需要进行异常处理或错误提示;
 * 在安全组合模式中,将这些方法下置到Composite中, 避免上述问题,但是客户端要进行节点类型(枝|叶)判断.
 */
	/**
	 * 添加构件
	 * @param c
	 */
	public abstract void add(Component c);
	
	/**
	 * 删除构件
	 * @param c
	 */
	public abstract void remove(Component c);
	
}
