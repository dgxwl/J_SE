package designpattern.builder.classic;

/**
 * Director指导生产者进行创建对象
 * @author Administrator
 *
 */
public class Director {
	
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	//direct()决定了product的创建过程
	public void direct(String head, String body, String hand, String foot) {
		builder.makeHead(head);
		builder.makeBody(body);
		builder.makeHand(hand);
		builder.makeFoot(foot);
	}
}
