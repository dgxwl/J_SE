package designpattern.structrual.decorator;

/**
 * 被装饰类: 具有完整功能的实现类.
 * @author Administrator
 *
 */
public class ConcreteComponent implements Component {

	@Override
	public void doA() {
		System.out.println("ConcreteComponent's doA().");
	}

}
