package designpattern.structrual.bridge;

/**
 * 桥接模式将抽象(Abstraction)与行为实现(Implementation)进行分离, 
 * 从而保持各部分的独立性, 降低了类与类之间的耦合度, 便于功能扩展.
 * Client为调用方.
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Circle circle = new Circle(new BlueColor());
		circle.paint();
	}
}
