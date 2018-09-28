package designpattern.structrual.flyweight;

/**
 * 享元模式(Flyweight Pattern);享元模式可以实现:
 * 通过复用避免创建大量的细粒度对象, 减少资源损耗;
 * 高效地提供被大量使用的对象.
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		Chess first = ChessFactory.getChess("Black");
		first.desc();
		first.print(1, 2);
		Chess second = ChessFactory.getChess("White");
		second.desc();
		second.print(2, 4);
		Chess third = ChessFactory.getChess("Black");
		System.out.println(first == third);
	}
}
