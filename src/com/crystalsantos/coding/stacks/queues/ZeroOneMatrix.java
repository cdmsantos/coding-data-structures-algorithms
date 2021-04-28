package com.crystalsantos.coding.stacks.queues;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] mat) {
		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) { // calculate
					queue.offer(new int[] { i, j });
				} else {
					mat[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		// down, right, up, left
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] dir : directions) {
				int i = current[0] + dir[0];
				int j = current[1] + dir[1];
				if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length
						|| mat[i][j] <= mat[current[0]][current[1]] + 1) {
					continue;
				}
				mat[i][j] = mat[current[0]][current[1]] + 1;
				queue.offer(new int[] { i, j });
			}
		}

		return mat;
	}

	public static void main(String[] args) {
		ZeroOneMatrix matrix = new ZeroOneMatrix();
//		int[][] mat = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		int[][] mat = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] result = matrix.updateMatrix(mat);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
