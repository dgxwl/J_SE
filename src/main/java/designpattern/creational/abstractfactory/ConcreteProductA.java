package designpattern.creational.abstractfactory;

/**
 * 产品实现类A
 * @author Administrator
 *
 */
public class ConcreteProductA implements IProduct {

	@Override
	public void desc() {
		System.out.println("Concrete product A.");
	}

}
