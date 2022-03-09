package com.crystalsantos.coding.facebook.trees.and.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Binary Tree Paths
 * 
 * 
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * 
 * A leaf is a node with no children.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5] Output: ["1->2->5","1->3"] Example 2:
 * 
 * Input: root = [1] Output: ["1"]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 100]. -100 <= Node.val <=
 * 100
 * 
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		if (root.left == null && root.right == null) {
			return Arrays.asList(Integer.toString(root.val));
		}

		LinkedList<String> paths = new LinkedList<>();
		constructPaths(root, "", paths);
		return paths;
	}

	public void constructPaths(TreeNode root, String path, LinkedList<String> paths) {
		if (root != null) {
			path += Integer.toString(root.val);
			if ((root.left == null) && (root.right == null)) { // if reach a leaf
				paths.add(path);
			} else {
				path += "->";
				constructPaths(root.left, path, paths);
				constructPaths(root.right, path, paths);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreePaths btPaths = new BinaryTreePaths();
		btPaths.run();
	}

	private void run() {
		TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
		printResult(binaryTreePaths(root1));
	}

	private void printResult(List<String> result) {
		System.out.print("[ ");
		for (String res : result) {
			System.out.print(res + " ");
		}
		System.out.print("]");
		System.out.println();
	}
}
