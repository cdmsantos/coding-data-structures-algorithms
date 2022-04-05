package com.crystalsantos.coding.amazon.treesandgraphs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Cut Off Trees for Golf Event
 * 
 * 
 * You are asked to cut off all the trees in a forest for a golf event. The
 * forest is represented as an m x n matrix. In this matrix:
 * 
 * 0 means the cell cannot be walked through. 1 represents an empty cell that
 * can be walked through. A number greater than 1 represents a tree in a cell
 * that can be walked through, and this number is the tree's height. In one
 * step, you can walk in any of the four directions: north, east, south, and
 * west. If you are standing in a cell with a tree, you can choose whether to
 * cut it off.
 * 
 * You must cut off the trees in order from shortest to tallest. When you cut
 * off a tree, the value at its cell becomes 1 (an empty cell).
 * 
 * Starting from the point (0, 0), return the minimum steps you need to walk to
 * cut off all the trees. If you cannot cut off all the trees, return -1.
 * 
 * You are guaranteed that no two trees have the same height, and there is at
 * least one tree needs to be cut off.
 * 
 * Example 1:
 * 
 * Input: forest = [[1,2,3],[0,0,4],[7,6,5]] Output: 6 Explanation: Following
 * the path above allows you to cut off the trees from shortest to tallest in 6
 * steps. Example 2:
 * 
 * 
 * Input: forest = [[1,2,3],[0,0,0],[7,6,5]] Output: -1 Explanation: The trees
 * in the bottom row cannot be accessed as the middle row is blocked. Example 3:
 * 
 * Input: forest = [[2,3,4],[0,0,5],[8,7,6]] Output: 6 Explanation: You can
 * follow the same path as Example 1 to cut off all the trees. Note that you can
 * cut off the first tree at (0, 0) before making any steps.
 * 
 * 
 * Constraints:
 * 
 * m == forest.length n == forest[i].length 1 <= m, n <= 50 0 <= forest[i][j] <=
 * 109
 */
public class CutOffTreesForGolfEvent {
	
	private final static int[][] dir = {{-1, 0} , {1, 0}, {0, 1}, {0, -1}};
	
	public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0; 
        
        int m = forest.size();
        int n = forest.get(0).size();
        
        // put trees in heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> x[2] - y[2]
        );
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    pq.add(new int[] {i, j, h});
                }
            }
        }
        
        // get minimal path for each tree
        int sum = 0;
        int[] start = new int[2];
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int steps = getMinStep(tree, start, m, n, forest);
            
            if (steps < 0) return -1;
            sum += steps;
            
            start[0] = tree[0];
            start[1] = tree[1];
        }
        
        return sum;
    }
    
    private static int getMinStep(int[] tree, int[] start, int m, int n, List<List<Integer>> forest) {
        int step = 0;
        Deque<int[]> q = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        
        
        
        q.addLast(start);
        while (!q.isEmpty()) {
            int length = q.size();
            
            for (int i = 0; i < length; i++) {
                int[] loc = q.removeFirst();
                if (loc[0] == tree[0] && loc[1] == tree[1]) return step;
                
                for (int[] d : dir) {
                    int x = loc[0] + d[0];
                    int y = loc[1] + d[1];
                    
                    if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && forest.get(x).get(y) != 0) {
                        q.addLast(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
    
}
