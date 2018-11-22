package designpattern.creational.abstractfactory;

import java.util.Random;

/**
 * 抽象工厂模式(abstract factory pattern)
 * 抽象工厂具有可以提供某个工厂的方法,不同的工厂分别生产不同的产品;
 * 客户类只需获得抽象工厂的指定实现类,用这个工厂实现类获得产品,
 * 而无需关心获得的具体产品是什么,实现了对象的创建与其使用的隔离.
 * 缺点: 最初编写代码时出现不必要的复杂性和额外工作,且更高级别的
 * 分离和抽象可能导致系统更难以调试和维护.
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		AbstractFactory factory = AbstractFactory.getConcreteFactory(randomFactoryType());
		IProduct product = factory.getProduct();
		product.desc();
	}
	
	public static String randomFactoryType() {
		String[] type = {"A", "B", "other"};
		return type[new Random().nextInt(3)];
	}
}
