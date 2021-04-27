package com.crystalsantos.coding.binarysearch;

public class BalancedBinaryTree {
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

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (root != null && root.left == null && root.right == null) {
			return true;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;			
		}

		return false;
	}

	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(height(node.left), height(node.right));
	}

	private void run() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node2.right = node3;

//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(3);
//		TreeNode node5 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(4);
//		TreeNode node7 = new TreeNode(4);
//
//		node1.left = node2;
//		node1.right = node3;
//
//		node2.left = node4;
//		node2.right = node5;
//
//		node4.left = node6;
//		node4.right = node7;

		System.out.println(isBalanced(node1));
	}

	public static void main(String[] args) {
		new BalancedBinaryTree().run();
	}
}
