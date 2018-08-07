package object;
/**
 * java.lang.Object是java中所有类的超类
 * Object在Java中被翻译为“对象”。但本质含义就是“东西”。
 * 
 * 重写Object相关方法
 * @author JAVA
 *
 */
public class Point {
	private int x;
	private int y;
	
	public Point() {
		
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 通常自定义的类若使用toStirng()方法就应当重写。
	 * 返回的字符串没有具体的格式要求，将来结合实际开发
	 * 需求而定。但是原则是返回字符串应当包含需要体现
	 * 的当前对象的属性信息
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	/**
	 * 重写equals()方法，比较对象内容是否一样。
	 * 该方法并不要求必须两个对象所有属性值都相同，要
	 * 结合将来实际开发需求而定。
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (o instanceof Point) {
			Point p = (Point)o;
			return this.x == p.x && this.y == p.y;
		}
		
		return false;
	}
}
