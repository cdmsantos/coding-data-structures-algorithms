package com.crystalsantos.coding.binarysearch;

public class DeleteNodeInABST {
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

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (root != null && root.left == null && root.right == null && root.val == key) {
			return null;
		}

		return delete(root, key);
	}

	private TreeNode delete(TreeNode node, int key) {

		if (node.val > key) {
			if (node.left != null) {
				node.left = delete(node.left, key);
			}
		} else if (node.val < key) {
			if (node.right != null) {
				node.right = delete(node.right, key);
			}
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			node.val = minValue(node.right);

			if (node.right != null) {
				node.right = delete(node.right, node.val);
			}
		}

		return node;
	}

	private int minValue(TreeNode root) {
		int minv = root.val;
		while (root.left != null) {
			minv = root.left.val;
			root = root.left;
		}
		return minv;
	}

	private void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.val + " ");
			inorderRec(root.right);
		}
	}

	public void run() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);

		node1.right = node2;

		int val = 1;

		TreeNode result = deleteNode(node1, val);
		inorderRec(result);
	}

	public static void main(String[] args) {
		new DeleteNodeInABST().run();
	}
}
