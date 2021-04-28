package com.crystalsantos.coding.stacks.queues;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int numberIslands = 0;
		int row = grid.length;
		int col = grid[0].length;
		//how you need to change from current position to all directions
		//down, right, up, left
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (grid[i][j] == '1') {
					numberIslands++;

					queue.add(new int[] { i, j });

					grid[i][j] = '2'; //mark as visited

					while (!queue.isEmpty()) {
						int[] currentIndex = queue.poll();

						for (int[] dir : directions) {
							int r = currentIndex[0] + dir[0];
							int c = currentIndex[1] + dir[1];

							if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == '1') {
								queue.add(new int[] { r, c });
								grid[r][c] = '2'; // mark adjacents as visited
							}
						}
					}
				}
			}
		}

		return numberIslands;
	}
    
    public static void main(String[] args) {
		NumberOfIslands islands = new NumberOfIslands();
		char[][] grid1 =
			   {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
		char[][] grid2 =
				{{'1', '1', '0', '0', '0'},
				 {'1', '1', '0', '0', '0'},
				 {'0', '0', '1', '0', '0'},
				 {'0', '0', '0', '1', '1'}};
		System.out.println(islands.numIslands(grid1));
		System.out.println(islands.numIslands(grid2));
	}
}
