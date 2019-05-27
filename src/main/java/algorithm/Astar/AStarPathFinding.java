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
		findPath(start);
		for (Node node : closedList) {
			System.out.println(node);
		}
	}
	
	private static Node start = new Node(1, 4);
	private static Node dest = new Node(6, 5);
	
//	private static List<Node> openList = new LinkedList<>();
	private static Queue<Node> closedList = new LinkedList<>();
	
	public static void findPath(Node currentNode) {
		//Queue<Node> pathStep = new LinkedList<>();
		
		//1.首先将起始位置加入closed列表
		closedList.add(currentNode);
		
		//2.找到相邻可达位置(不走斜线)
		List<Node> neighbors  = new LinkedList<>();
		
		int currentX = currentNode.x;
		int currentY = currentNode.y;
		
		//查找将四周的格子将可达的挑选出来
		int topX = currentX;
		int topY = currentY - 1;
		if (canAddToOpen(topX, topY)) {
			Node n = new Node(topX, topY);
			if (n.equals(dest)) {
				closedList.add(n);
				return ;
			}
			n.prev = currentNode;
			neighbors.add(n);
		}
		
		int bottomX = currentX;
		int bottomY = currentY + 1;
		if (canAddToOpen(bottomX, bottomY)) {
			Node n = new Node(bottomX, bottomY);
			if (n.equals(dest)) {
				closedList.add(n);
				return ;
			}
			n.prev = currentNode;
			neighbors.add(n);
		}
		
		int leftX = currentX - 1;
		int leftY = currentY;
		if (canAddToOpen(leftX, leftY)) {
			Node n = new Node(leftX, leftY);
			if (n.equals(dest)) {
				closedList.add(n);
				return ;
			}
			n.prev = currentNode;
			neighbors.add(n);
		}
		
		int rightX = currentX + 1;
		int rightY = currentY;
		if (canAddToOpen(rightX, rightY)) {
			Node n = new Node(rightX, rightY);
			if (n.equals(dest)) {
				closedList.add(n);
				return ;
			}
			n.prev = currentNode;
			neighbors.add(n);
		}
		
		//3.计算邻近的F, G, H
		for (Node n : neighbors) {
			n.G = n.prev.G + 1;
			n.H = calManhattanDistance(n.x, n.y, dest.x, dest.y);
			n.F = n.G + n.H;
		}
		
		//4.找出F最小的
		int minF = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < neighbors.size(); i++) {
			if (neighbors.get(i).F < minF) {
				minF = neighbors.get(i).F;
				minIndex = i;
			}
		}

		findPath(neighbors.get(minIndex));
	}
	
	//获取当前位置的所有相邻可达位置
//	public static List<Node> findNeighbor(Node currentNode) {
//		List<Node> list = new LinkedList<>();
//		
//		int currentX = currentNode.x;
//		int currentY = currentNode.y;
//		
//		//查找将四周的格子将可达的挑选出来
//		int topX = currentX;
//		int topY = currentY - 1;
//		if (canAddToOpen(topX, topY)) {
//			Node n = new Node(topX, topY);
//			n.prev = currentNode;
//			list.add(n);
//		}
//		
//		int bottomX = currentX;
//		int bottomY = currentY + 1;
//		if (canAddToOpen(bottomX, bottomY)) {
//			Node n = new Node(bottomX, bottomY);
//			n.prev = currentNode;
//			list.add(n);
//		}
//		
//		int leftX = currentX - 1;
//		int leftY = currentY;
//		if (canAddToOpen(leftX, leftY)) {
//			Node n = new Node(leftX, leftY);
//			n.prev = currentNode;
//			list.add(n);
//		}
//		
//		int rightX = currentX + 1;
//		int rightY = currentY;
//		if (canAddToOpen(rightX, rightY)) {
//			Node n = new Node(rightX, rightY);
//			n.prev = currentNode;
//			list.add(n);
//		}
//		
//		return list;
//	}
	
	public static int calManhattanDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}
	
	public static boolean canAddToOpen(int x, int y) {  //需要满足: 1非障碍, 2不超出地图范围, 3不在closed中
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
