package com.crystalsantos.coding.binarysearch;

public class InsertIntoBinarySearchTree {
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

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		insert(root, val);
		
		return root;
	}

	private void insert(TreeNode node, int val) {
		if(val > node.val) {
			if(node.right != null) {
				insert(node.right, val);
			} else {
				node.right = new TreeNode(val);
			}
		}
		
		if(val < node.val) {
			if(node.left != null) {
				insert(node.left, val);
			} else {
				node.left = new TreeNode(val);
			}
		}
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

		int val = 5;
		
		TreeNode result = insertIntoBST(node1, val);
		System.out.println(result.val);
	}

	public static void main(String[] args) {
		new InsertIntoBinarySearchTree().run();
	}
}
