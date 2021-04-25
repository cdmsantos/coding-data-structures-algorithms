package com.crystalsantos.coding.trees;

public class PathSum {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		if (root != null && root.left == null && root.right == null) {
			if (root.val != targetSum) {
				return false;
			} else {
				return true;
			}
		}

		return calculateSum(root, targetSum, 0);
	}

	private static boolean calculateSum(TreeNode root, int targetSum, int currentSum) {
		boolean pathLeft = false;
		boolean pathRight = false;
		boolean result = false;

		if (root.left == null && root.right == null) { //definition of leaf
			if ((currentSum + root.val) == targetSum) {
				result = true;
			} else {
				result = false;
			}
		}
		if (root.left != null) {
			pathLeft = calculateSum(root.left, targetSum, currentSum + root.val);
		}

		if (root.right != null) {
			pathRight = calculateSum(root.right, targetSum, currentSum + root.val);
		}

		if (pathRight || pathLeft || result) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		TreeNode leaf1 = new TreeNode(7);
		TreeNode leaf2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(11, leaf1, leaf2);		
		TreeNode node2 = new TreeNode(4, node1, null);
		
		TreeNode leaf3 = new TreeNode(13);
		TreeNode leaf4 = new TreeNode(1);
		
		TreeNode node3 = new TreeNode(4, null, leaf4);
		TreeNode node4 = new TreeNode(8, leaf3, node3);
		
		TreeNode root = new TreeNode(5, node2, node4);
		
		System.out.println(hasPathSum(root, 22));
		
//		TreeNode leaf1 = new TreeNode(-3);
//		TreeNode root = new TreeNode(-2, null, leaf1);
//		System.out.println(hasPathSum(root, -5));
	}
}
