package designpattern.creational.factorymethod;

public class ConcreteFactoryB implements IFactory {

	@Override
	public IProduct getProduct() {
		return new ConcreteProductB();
	}

}
