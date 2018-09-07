package designpattern.structrual.decorator;

/**
 * 装饰类(通常是一个抽象类,定义基本装饰效果);与被装饰类实现了
 * 同样的接口,并在内部维护一个装饰类的实例(通过构造方法初始化).
 * @author Administrator
 *
 */
public class Decorator implements Component {
	//如果是抽象类权限是protected
	private ConcreteComponent component;

	public Decorator(ConcreteComponent component) {
		this.component = component;
	}

	@Override
	public void doA() {
		component.doA();
		System.out.println("Decorator's decoration.");
	}

}
