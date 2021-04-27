package com.crystalsantos.coding.binarysearch;

public class SearchInBinarySearchTree {
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

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}

		return search(root, val);
	}

	private TreeNode search(TreeNode node, int val) {
		if (node != null && node.val == val) {
			return node;
		}

		if (node.left != null && node.val > val) {
			return search(node.left, val);
		}

		if (node.right != null && node.val < val) {
			return search(node.right, val);
		}

		return null;
	}
	
	public void run() {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(7);

		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;

		int val = 2;
		
		TreeNode result = searchBST(node1, val);
		System.out.println(result.val);
	}

	public static void main(String[] args) {
		new SearchInBinarySearchTree().run();
	}
}
