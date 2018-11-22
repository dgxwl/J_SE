package designpattern.creational.abstractfactory;

/**
 * 工厂实现类B, 专门生成产品实现类B
 * @author Administrator
 *
 */
public class ConcreteFactoryB extends AbstractFactory {

	@Override
	public IProduct getProduct() {
		return new ConcreteProductB();
	}

}
