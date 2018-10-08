package designpattern.behavioral.memento._whitebox;

/**
 * 备忘录管理者角色: 负责管理并保存备忘录
 * @author Administrator
 *
 */
public class CareTaker {
	private Memento memento; //只存储一个状态(一个检查点);可替换为集合设置多个检查点

	public CareTaker(Memento memento) {
		super();
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
}
