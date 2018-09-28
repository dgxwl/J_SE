package designpattern.structrual.flyweight;

/**
 * 享元抽象类: 保证一致外观
 * @author Administrator
 *
 */
public abstract class Chess {
	protected int x;
	protected int y;
	protected String chessColor;

	public Chess(String chessColor) {
		this.chessColor = chessColor;
	}

	public abstract void desc();

	public void print(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println(chessColor + ": (" + x + ", " + y + ")");
	}
}
