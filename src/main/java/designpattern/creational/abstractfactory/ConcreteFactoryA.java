package designpattern.creational.abstractfactory;

/**
 * 工厂实现类A, 专门生成产品实现类A
 * @author Administrator
 *
 */
public class ConcreteFactoryA extends AbstractFactory {

	@Override
	public IProduct getProduct() {
		return new ConcreteProductA();
	}

}
