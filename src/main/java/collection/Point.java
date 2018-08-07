package collection;
/**
 * 使用当前类的实例作为集合元素测试Collections对自定义
 * 元素的集合排序
 * @author JAVA
 *
 */
public class Point implements Comparable<Point> {
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
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
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * 当实现了Comparable接口后，要求必须重写抽象方法：
	 * int compareTo(T t)
	 * 该方法的作用是比较当前对象(this)与参数对象的大小.
	 * 
	 * 返回值不关注具体值，只关注取值范围：
	 * 当返回值>0：当前对象大于对象参数
	 * 当返回值<0：当前对象小于对象参数
	 * 当返回值=0：当前对象等于对象参数
	 */
	@Override
	public int compareTo(Point o) {
		int len = this.x * this.x + this.y * this.y;
		int olen = o.x * o.x + o.y * o.y;
		return len - olen;
	}
}
