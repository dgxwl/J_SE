package designpattern.behavioral.memento._whitebox;

/**
 * 备忘录类: 负责存储Originator对象的内部状态
 * @author Administrator
 *
 */
public class Memento {
	//与Originator一致的属性
	private int state;
	
	public Memento() {
	}

	public Memento(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
