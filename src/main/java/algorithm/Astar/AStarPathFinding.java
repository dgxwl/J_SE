package algorithm.Astar;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AStarPathFinding {

	public static final int[][] MAP = {
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }
	};

	public static void main(String[] args) {
		
	}
	
	private static List<Node> openList = new LinkedList<>();
	private static List<Node> closedList = new LinkedList<>();
	
	public static Queue<Node> findPath(Node start, Node dest) {
		Queue<Node> pathStep = new LinkedList<>();
		
		//1.首先将当前位置加入closed列表
		closedList.add(start);
		
		//2.找到相邻可达位置(不走斜线)
		List<Node> neighbors = findNeighbor(start);
	}
	
	//获取当前位置的所有相邻可达位置
	public static List<Node> findNeighbor(Node currentNode) {
		List<Node> list = new LinkedList<>();
		
		int currentX = currentNode.x;
		int currentY = currentNode.y;
		
		//查找将四周的格子将可达的挑选出来
		int topX = currentX;
		int topY = currentY - 1;
		if (canAddToOpen(topX, topY)) {
			list.add(new Node(topX, topY));
		}
		
		int bottomX = currentX;
		int bottomY = currentY + 1;
		if (canAddToOpen(bottomX, bottomY)) {
			list.add(new Node(bottomX, bottomY));
		}
		
		int leftX = currentX - 1;
		int leftY = currentY;
		if (canAddToOpen(leftX, leftY)) {
			list.add(new Node(leftX, leftY));
		}
		
		int rightX = currentX + 1;
		int rightY = currentY;
		if (canAddToOpen(rightX, rightY)) {
			list.add(new Node(rightX, rightY));
		}
		
		return list;
	}
	
	public static boolean canAddToOpen(int x, int y) {  //需要满足: 1非障碍, 2不超出地图范围
		return canReach(x, y) && !inClosedList(x, y);
	}
	
	public static boolean canReach(int x, int y) {  //非障碍
		if (x < 0 || x > MAP.length - 1 || y < 0 || y > MAP[0].length - 1) {
			return false;
		}
		return MAP[x][y] == 0;
	}
	
	public static boolean inClosedList(int x, int y) {  //位置不在closedList里
		for (Node n : closedList) {
			if (n.x == x && n.y == y) {
				return true;
			}
		}
		return false;
	}
}
