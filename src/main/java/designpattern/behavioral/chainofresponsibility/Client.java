package designpattern.behavioral.chainofresponsibility;

/**
 * 责任链模式(chain-of-responsibility pattern): 
 * 由请求对象和一系列处理对象组成,每个处理对象都包含自定义的处理命令对象的逻辑,
 * 所有处理对象组成链表,请求沿着处理对象链传递,直到有对象处理该请求.
 * 请求对象不必知道具体的处理请求的对象,处理对象链可以灵活地拆分重组,实现了松耦合.
 * 缺点: 实际处理请求的类只有一个,其他的只起到传递作用,产生大量无用对象.
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		//模仿请假过程
		Leader manager = new Manager("manager");
		Leader director = new Director("director");
		//构建链表
		manager.setSuccessor(director);
		//处理请求
		Request request = new Request(3, "some reason");
		manager.processRequest(request);
	}
}
