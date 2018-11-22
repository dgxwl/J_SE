package designpattern.creational.abstractfactory;

/**
 * 抽象工厂
 * @author Administrator
 *
 */
public abstract class AbstractFactory {
	/**
	 * 提供具体产品,以接口类型返回
	 * @return
	 */
	public abstract IProduct getProduct();
	
	/**
	 * Client端用来选择具体的工厂
	 * @param factoryType
	 * @return
	 */
	public static AbstractFactory getConcreteFactory(String factoryType) {
		switch (factoryType) {
		case "A":
			return new ConcreteFactoryA();
		case "B":
			return new ConcreteFactoryB();
		default:
			throw new RuntimeException("No such factory type.");
		}
	}
}
