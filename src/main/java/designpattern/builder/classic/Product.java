package designpattern.builder.classic;

/**
 * 产品
 * @author Administrator
 *
 */
public class Product {
	String head;
	String body;
	String hand;
	String foot;
	
	@Override
	public String toString() {
		return "Product [head=" + head + ", body=" + body + ", hand=" + hand + ", foot=" + foot + "]";
	}
}
