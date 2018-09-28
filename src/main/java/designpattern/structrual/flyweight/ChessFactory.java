package designpattern.structrual.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * @author Administrator
 *
 */
public class ChessFactory {
	private static Map<String, Chess> chesses = new HashMap<>();
	static {
		chesses.put("White", new WhiteChess("White"));
		chesses.put("Black", new BlackChess("Black"));
	}
	
	public static Chess getChess(String chessColor) {
		return chesses.get(chessColor);
	}
}
