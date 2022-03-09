package com.crystalsantos.coding.facebook.trees.and.graphs;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 
 * Number of Islands
 * 
 * 
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"],
 * ["1","1","0","0","0"], ["0","0","0","0","0"] ] Output: 1 Example 2:
 * 
 * Input: grid = [ ["1","1","0","0","0"], ["1","1","0","0","0"],
 * ["0","0","1","0","0"], ["0","0","0","1","1"] ] Output: 3
 * 
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 300 grid[i][j] is '0' or
 * '1'.
 * 
 */
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
