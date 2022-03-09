package com.crystalsantos.codility.facebook.trees.and.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Binary Tree Vertical Order Traversal
 * 
 * 
 * Given the root of a binary tree, return the vertical order traversal of its
 * nodes' values. (i.e., from top to bottom, column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left to
 * right.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[9],[3,15],[20],[7]] Example
 * 2:
 * 
 * 
 * Input: root = [3,9,8,4,0,1,7] Output: [[4],[9],[3,0,1],[8],[7]] Example 3:
 * 
 * 
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5] Output:
 * [[4],[9,5],[3,0,1],[8,2],[7]]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100]. -100 <= Node.val <=
 * 100
 * 
 *
 */
public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		Map<Integer, List<Integer>> map = new TreeMap<>();
		Deque<TreeNode> nodes = new ArrayDeque<>();
		Deque<Integer> cols = new ArrayDeque<>();

		nodes.add(root);
		cols.add(0);

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			int col = cols.poll();

			map.putIfAbsent(col, new ArrayList<>());
			map.get(col).add(node.val);

			if (node.left != null) {
				nodes.add(node.left);
				cols.add(col - 1);
			}

			if (node.right != null) {
				nodes.add(node.right);
				cols.add(col + 1);
			}
		}

		return new ArrayList<>(map.values());
	}
}
