package com.crystalsantos.codility.facebook.trees.and.graphs;

/***
 * 
 * Diameter of Binary Tree
 * 
 * 
 * Given the root of a binary tree, return the length of the diameter of the
 * tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5] Output: 3 Explanation: 3 is the length of the path
 * [4,2,1,3] or [5,2,1,3]. Example 2:
 * 
 * Input: root = [1,2] Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -100 <= Node.val <=
 * 100
 */
public class DiameterOfBinaryTree {
	int diameter;
	
	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;

		if (root == null || (root.left == null && root.right == null)) {
			return diameter;
		}

		longestPath(root);
		return diameter;
	}

	public int longestPath(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftPath = longestPath(node.left);
		int rightPath = longestPath(node.right);

		diameter = Math.max(leftPath + rightPath, diameter);

		return Math.max(leftPath, rightPath) + 1;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
		diameter.run();
	}

	private void run() {
		TreeNode root1 = new TreeNode(8, new TreeNode(6, new TreeNode(2), new TreeNode(7)),
				new TreeNode(15, null, new TreeNode(20)));
		System.out.println(diameterOfBinaryTree(root1));

		TreeNode root2 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
		System.out.println(diameterOfBinaryTree(root2));
	}
}
