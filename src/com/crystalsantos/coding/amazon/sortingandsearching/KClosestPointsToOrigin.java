package com.crystalsantos.coding.amazon.sortingandsearching;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * K Closest Points to Origin
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]] Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). The distance between (-2,
 * 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to
 * the origin. We only want the closest k = 1 points from the origin, so the
 * answer is just [[-2,2]]. Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2 Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= points.length <= 104 -104 < xi, yi < 104
 */
public class KClosestPointsToOrigin {

	class Point {
		int[] point;
		double distance;

		public Point(int[] point, double distance) {
			this.point = point;
			this.distance = distance;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		if (k == points.length) {
			return points;
		}

		if (k > points.length) {
			return null;
		}

		int[][] result = new int[k][2];
		Queue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (p1.distance < p2.distance) {
					return -1;
				}
				if (p1.distance > p2.distance) {
					return 1;
				}
				return 0;
			}
		});

		for (int i = 0; i < points.length; i++) {
			queue.add(new Point(points[i], distance(points[i])));
		}

		for (int i = 0; i < k; i++) {
			result[i] = queue.poll().point;
		}

		return result;
	}

	private double distance(int[] point) {
		return Math.sqrt(Math.pow(point[0] - 0, 2) + Math.pow(point[1] - 0, 2));
	}

	public static void main(String[] args) {
		KClosestPointsToOrigin closestPoints = new KClosestPointsToOrigin();
		closestPoints.printResult(closestPoints.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)); // [[-2,2]]
		closestPoints.printResult(closestPoints.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)); // [[3,3],[-2,4]]
	}

	private void printResult(int[][] result) {
		System.out.print("[");
		for (int i = 0; i < result.length; i++) {
			System.out.print("[");
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.print("]");
		}
		System.out.print("]");
		System.out.println();
	}
}
