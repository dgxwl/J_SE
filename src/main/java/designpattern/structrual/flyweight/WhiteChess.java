package designpattern.structrual.flyweight;
/**
 * 享元具体类: 白棋
 * @author Administrator
 *
 */
public class WhiteChess extends Chess {

	public WhiteChess(String chessColor) {
		super(chessColor);
	}

	@Override
	public void desc() {
		System.out.println("This is a " + chessColor + " chess.");
	}
}
