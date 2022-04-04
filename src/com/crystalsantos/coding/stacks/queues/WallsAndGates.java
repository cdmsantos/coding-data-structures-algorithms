package com.crystalsantos.coding.stacks.queues;

/**
 * Walls and Gates
 * 
 * You are given an m x n grid rooms initialized with these three possible
 * values.
 * 
 * -1 A wall or an obstacle. 0 A gate. INF Infinity means an empty room. We use
 * the value 231 - 1 = 2147483647 to represent INF as you may assume that the
 * distance to a gate is less than 2147483647. Fill each empty room with the
 * distance to its nearest gate. If it is impossible to reach a gate, it should
 * be filled with INF.
 * 
 * Example 1:
 * 
 * Input: rooms =
 * [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]] Example 2:
 * 
 * Input: rooms = [[-1]] Output: [[-1]]
 * 
 * Constraints:
 * 
 * m == rooms.length n == rooms[i].length 1 <= m, n <= 250 rooms[i][j] is -1, 0,
 * or 231 - 1.
 */
public class WallsAndGates {

	private static int[] directions = { 0, 1, 0, -1, 0 };

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0) {
			return;
		}

		for (int row = 0; row < rooms.length; row++) {
			for (int col = 0; col < rooms[0].length; col++) {
				if (rooms[row][col] == 0) {
					dfs(rooms, row, col);
				}
			}
		}
	}

	private void dfs(int[][] rooms, int i, int j) {
		for (int k = 0; k < 4; ++k) {
			int p = i + directions[k];
			int q = j + directions[k + 1];
			if (0 <= p && p < rooms.length && 0 <= q && q < rooms[0].length && rooms[p][q] > rooms[i][j] + 1) {
				rooms[p][q] = rooms[i][j] + 1;
				dfs(rooms, p, q);
			}
		}
	}

}
