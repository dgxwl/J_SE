package designpattern.structrual.decorator;

/**
 * 装饰模式(Decorator Pattern)可对一个现有类的功能进行扩展
 * 而不派生子类(比派生更灵活),同时不改变其结构,不影响原有功能;
 * 可定义多个具有不同效果的装饰类.
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Decorator decorator = new Decorator(new ConcreteComponent());
		decorator.doA();
	}
}
