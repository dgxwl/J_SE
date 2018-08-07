package designpattern.builder.classic;

/**
 * 生产者实现类
 * @author Administrator
 *
 */
public class BuilderImpl implements Builder {
	//builder生产product
	private Product product = new Product();

	@Override
	public void makeHead(String head) {
		product.head = head;
	}

	@Override
	public void makeBody(String body) {
		product.body = body;
	}

	@Override
	public void makeHand(String hand) {
		product.hand = hand;
	}

	@Override
	public void makeFoot(String foot) {
		product.foot = foot;
	}

	@Override
	public Product getProduct() {
		return product;
	}
}
