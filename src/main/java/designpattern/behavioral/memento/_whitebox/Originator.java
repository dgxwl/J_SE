package designpattern.behavioral.memento._whitebox;

/**
 * 原始类(发起人角色): 被记录的类, 可创建备忘录并可以使用备忘录恢复内部状态。
 * @author Administrator
 *
 */
public class Originator {
	private int state;
	
	public Originator() {
	}

	public Originator(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public Memento createMemento() {
		return new Memento(state);
	}
	
	public void restoreFromMemento(Memento memento) {
		this.state = memento.getState();
	}
}
