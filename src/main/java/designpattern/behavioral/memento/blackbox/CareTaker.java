package designpattern.behavioral.memento.blackbox;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	//检查点们
	List<Originator.Memento> states = new ArrayList<Originator.Memento>();
	
	public void addState(Originator.Memento memento) {
		states.add(memento);
	}
	
	public Originator.Memento restoreState(int index) {
		return states.get(index);
	}
}
