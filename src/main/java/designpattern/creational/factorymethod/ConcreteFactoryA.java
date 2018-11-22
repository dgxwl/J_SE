package designpattern.creational.factorymethod;

public class ConcreteFactoryA implements IFactory {

	@Override
	public IProduct getProduct() {
		return new ConcreteProductA();
	}

}
