package designpattern.structrual.facade;

/**
 * 外观模式(Facade Pattern)
 * 隐藏了系统的复杂性,为子系统中的一组接口提供了一个统一的访问接口,
 * 使得子系统更容易被访问或使用(使Client与子系统部件解耦).
 * "封装交互,简化调用"
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		ComputerFacade computerFacade = new ComputerFacade();
		computerFacade.start();
	}
}
