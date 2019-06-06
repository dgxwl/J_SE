package algorithm.Astar;

public class Point {
	protected int x;
	protected int y;

	protected int G; // 起始位置到当前位置的步数
	protected int H; // 当前位置到目标位置的步数估算(曼哈顿距离)
	protected int F; // G与H的和

	protected Point prev; // 本节点的上一个节点

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
