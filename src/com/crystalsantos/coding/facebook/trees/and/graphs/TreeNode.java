package com.crystalsantos.coding.facebook.trees.and.graphs;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	Character valS;

	TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}
	
	TreeNode(Character valS) {
		this.valS = valS;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	TreeNode(Character valS, TreeNode left, TreeNode right) {
		this.valS = valS;
		this.left = left;
		this.right = right;
	}
}
