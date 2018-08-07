package designpattern.builder.classic;

/**
 * 经典的GOF builder模式, 由director、builder、product组成.
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		//创建builder
		Builder builder = new BuilderImpl();
		//创建director
		Director director = new Director(builder);
		//director指导builder生产product
		director.direct("头部", "身体", "手", "脚");
		//builder交付product
		Product product = builder.getProduct();
		
		System.out.println(product);
	}
}
