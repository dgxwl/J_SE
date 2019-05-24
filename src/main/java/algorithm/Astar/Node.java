package algorithm.Astar;

public class Node {
	protected int x;
	protected int y;

	protected int G; // 起始位置到当前位置的步数
	protected int H; // 当前位置到目标位置的步数估算(曼哈顿距离)
	protected int F; // G与H的和

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
