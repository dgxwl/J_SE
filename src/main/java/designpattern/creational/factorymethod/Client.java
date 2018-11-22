package designpattern.creational.factorymethod;

/**
 * 工厂方法(factory method pattern)
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		IFactory factory1 = new ConcreteFactoryA();
		IProduct product1 = factory1.getProduct();
		product1.desc();
		
		IFactory factory2 = new ConcreteFactoryB();
		IProduct product2 = factory2.getProduct();
		product2.desc();
	}
}
