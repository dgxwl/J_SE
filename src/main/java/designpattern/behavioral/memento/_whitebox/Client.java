package designpattern.behavioral.memento._whitebox;

/**
 * 备忘录模式(Memento Pattern)提供了将对象恢复到其先前状态的能力;
 * 在不破坏封装性的前提下,捕获一个对象的内部状态,并在该对象之外保存这个状态.
 * 白箱实现: 备忘录角色的内部所存储的状态对所有对象公开(破坏封装性).
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Originator originator = new Originator(1);
		System.out.println("初始状态: " + originator.getState());
		//存储originator此时状态
		CareTaker careTaker = new CareTaker(originator.createMemento());
		originator.setState(3);
		System.out.println("更改后状态: " + originator.getState());
		//从memento恢复状态
		originator.restoreFromMemento(careTaker.getMemento());
		System.out.println("恢复后状态: " + originator.getState());
	}
}
