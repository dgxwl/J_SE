package designpattern.behavioral.memento.blackbox;

/**
 * 备忘录模式: 黑箱实现
 * 对发起人(Originator)角色提供一个宽接口,为其他对象提供一个窄接口(accessible only).
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Originator originator = new Originator(1);
		System.out.println("初始状态: " + originator.getState());
		CareTaker careTaker = new CareTaker();
		careTaker.addState(originator.createMemento());
		originator.setState(2);
		careTaker.addState(originator.createMemento());
		originator.setState(3);
		careTaker.addState(originator.createMemento());
		System.out.println("现在状态: " + originator.getState());
		originator.restoreFromMemento(careTaker.restoreState(1));
		System.out.println("恢复状态到: " + originator.getState());
	}
}
