package algorithm.Astar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A* 寻路算法
 * @author Administrator
 *
 */
public class AStarPathFinding {

	public static final int[][] MAP = {
			{0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0}
	};
	
	private static Point start = new Point(1, 4);  //给定起点
	private static Point dest = new Point(6, 5);  //给定目标点

	public static void main(String[] args) {
		Point destWithPath = findPath(start);
		
		while (destWithPath != null) {
			MAP[destWithPath.y][destWithPath.x] = 6;
			destWithPath = destWithPath.prev;
		}
		
		for (int[] is : MAP) {
			System.out.println(Arrays.toString(is));
		}
	}
	
	private static List<Point> openList = new LinkedList<>();
	private static List<Point> closedList = new LinkedList<>();
	
	public static Point findPath(Point currentPoint) {
		//1.首先将起始位置加入closed列表
		closedList.add(currentPoint);
		
		//2.找到相邻可到达位置(不走斜线)
		int currentX = currentPoint.x;
		int currentY = currentPoint.y;
		//查找四周的点(不走斜线), 3.将可到达的计算G,H,F值, 4.并加入到openList
		int topX = currentX;
		int topY = currentY - 1;
		handleNeighbor(topX, topY, currentPoint);
		
		int bottomX = currentX;
		int bottomY = currentY + 1;
		handleNeighbor(bottomX, bottomY, currentPoint);
		
		int leftX = currentX - 1;
		int leftY = currentY;
		handleNeighbor(leftX, leftY, currentPoint);
		
		int rightX = currentX + 1;
		int rightY = currentY;
		handleNeighbor(rightX, rightY, currentPoint);
		
		if (openList.size() == 0) {  //没有可到达终点的路径, 返回
			return null;
		}
		
		//检查目标点是否已在openList中, 如果存在即找到了完整路径, 返回
		for (Point p : openList) {
			if (p.equals(dest)) {
				return p;
			}
		}

		//5.从openList中找出F最小的, 移除并加入closedList
		Point minFPoint = openList.get(0);
		int minFPointIndex = 0;
		for (int i = 1; i < openList.size(); i++) {
			Point n = openList.get(i);
			if (n.F < minFPoint.F) {
				minFPoint = n;
				minFPointIndex = i;
			}
		}
		
		openList.remove(minFPointIndex);

		return findPath(minFPoint);
	}
	
	public static void handleNeighbor(int neighborX, int neighborY, Point currentPoint) {  //包括计算G,H,F, 添加到openList(如果不在openList中)
		if (canAddToOpen(neighborX, neighborY)) {
			for (Point point : openList) {
				int newG = point.prev.G + 1;
				if (point.x == neighborX && point.y == neighborY) {  //如果此节点在openList中已存在, 仅更新prev,G,F
					if (newG < point.G) {
						point.prev = currentPoint;
						point.G = newG;
						point.F = point.G + point.H;
					}
					
					return ;
				}
			}
			
			/*
			 * 节点在openList中不存在, 计算G, H, F并加入openList
			 * G: 起点到当前点的步数
			 * H: 当前点到目标点的预估步值(使用曼哈顿距离预估)
			 * F: G + H
			 */
			Point n = new Point(neighborX, neighborY);
			n.prev = currentPoint;
			n.G = n.prev.G + 1;
			n.H = calManhattanDistance(n.x, n.y, dest.x, dest.y);
			n.F = n.G + n.H;
			openList.add(n);
		}
	}
	
	//计算两点的曼哈顿距离(作为H值)
	public static int calManhattanDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	public static boolean canAddToOpen(int x, int y) {  //可加入openList的点需要满足: 1非障碍, 2不超出地图范围, 3不在closedList中
		return canReach(x, y) && !inClosedList(x, y);
	}
	
	public static boolean canReach(int x, int y) {  //可到达: 非障碍且不超出地图范围
		if (x < 0 || x > MAP[0].length - 1 || y < 0 || y > MAP.length - 1) {
			return false;
		}
		return MAP[y][x] == 0;
	}
	
	public static boolean inClosedList(int x, int y) {  //位置在closedList里
		for (Point n : closedList) {
			if (n.x == x && n.y == y) {
				return true;
			}
		}
		return false;
	}
}
