package com.crystalsantos.coding.facebook.trees.and.graphs;

/****
 * 
 * Binary Tree Maximum Path Sum
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes in the sequence has an edge connecting them. A node can only appear in
 * the sequence at most once. Note that the path does not need to pass through
 * the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any non-empty
 * path.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3] Output: 6 Explanation: The optimal path is 2 -> 1 -> 3
 * with a path sum of 2 + 1 + 3 = 6. Example 2:
 * 
 * 
 * Input: root = [-10,9,20,null,null,15,7] Output: 42 Explanation: The optimal
 * path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 3 * 104]. -1000 <=
 * Node.val <= 1000
 * 
 */
public class BinaryTreeMaximumPathSum {
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxGain(root);
		return maxSum;
	}

	private int maxGain(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftGain = Math.max(maxGain(root.left), 0);
		int rightGain = Math.max(maxGain(root.right), 0);

		maxSum = Math.max((root.val + leftGain + rightGain), maxSum);
		return root.val + Math.max(leftGain, rightGain);
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum sum = new BinaryTreeMaximumPathSum();
		sum.run();
	}

	private void run() {
		TreeNode root1 = new TreeNode(-10, new TreeNode(9),
				new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(maxPathSum(root1));

		TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		System.out.println(maxPathSum(root2));

//		TreeNode root3 = new TreeNode(0);
//		System.out.println(maxPathSum(root3));
//		
//		TreeNode root4 = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
//		System.out.println(maxPathSum(root4));
	}

}
