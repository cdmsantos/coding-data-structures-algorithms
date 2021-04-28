package com.crystalsantos.coding.stacks.queues;

import java.util.Stack;

public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int originalColor = image[sr][sc];
		boolean[][] visited = new boolean[image.length][image[0].length];
		// down, right, up, left
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		Stack<Integer[]> checkColor = new Stack<Integer[]>();
		checkColor.add(new Integer[] { sr, sc });

		while (!checkColor.isEmpty()) {
			Integer[] current = checkColor.pop();
			if (current != null && image[current[0]][current[1]] == originalColor && !visited[current[0]][current[1]]) {
				image[current[0]][current[1]] = newColor;
				visited[current[0]][current[1]] = true;
				for (int i = 0; i < directions.length; i++) {
					int row = current[0] + directions[i][0];
					int column = current[1] + directions[i][1];
					if (row >= 0 && row < image.length && column >= 0 && column < image[0].length) {
						checkColor.add(new Integer[] { row, column });
					}
				}
			}
		}

		return image;
	}

	public static void main(String[] args) {
		FloodFill flood = new FloodFill();
		int[][] image = new int[][] { { 0,0,0 }, { 0,1,1 } };
		int sr = 1;
		int sc = 1;
		int newColor = 1;
		int[][] result = flood.floodFill(image, sr, sc, newColor);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
