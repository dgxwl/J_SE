package designpattern.structrual.flyweight;
/**
 * 享元具体类: 黑棋
 * @author Administrator
 *
 */
public class BlackChess extends Chess {

	public BlackChess(String chessColor) {
		super(chessColor);
	}

	@Override
	public void desc() {
		System.out.println("This is a " + chessColor + " chess.");
	}
}
