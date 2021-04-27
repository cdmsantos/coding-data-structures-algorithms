package com.crystalsantos.coding.binarysearch;

public class ValidateBinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return false;
		}

		if (root != null && root.left == null && root.right == null) {
			return true;
		}

		return checkNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	private boolean checkNode(TreeNode node, double min, double max) {
		if (node == null) {
			return true;
		}

		if (node.val <= min || node.val >= max) {
			return false;
		}

		return (checkNode(node.left, min, node.val) && checkNode(node.right, node.val, max));
	}

	public void run() {
		TreeNode node1 = new TreeNode(-2147483648);
		TreeNode node2 = new TreeNode(-2147483648);

		node1.left = node2;

		System.out.println(isValidBST(node1));
	}

	public static void main(String[] args) {
		new ValidateBinarySearchTree().run();
	}
}
