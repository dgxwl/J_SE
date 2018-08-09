package designpattern.structrual.bridge;

/**
 * 抽象类(桥接作用)
 * @author Administrator
 *
 */
public abstract class Shape {
	//引入行为接口, 桥接对象和行为
	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract void paint();
}
