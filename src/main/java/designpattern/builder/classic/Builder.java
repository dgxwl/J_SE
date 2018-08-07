package designpattern.builder.classic;

/**
 * 生产者接口, 可扩展出多种生产者
 * @author Administrator
 *
 */
public interface Builder {
	void makeHead(String head);
	void makeBody(String body);
	void makeHand(String hand);
	void makeFoot(String foot);
	Product getProduct();
}
