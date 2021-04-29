package com.crystalsantos.coding.recursion;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	public class TreeNode {
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

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}

		return constructTrees(1, n);
	}

	private ArrayList<TreeNode> constructTrees(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<>();
		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> leftSubtree = constructTrees(start, i - 1);
			ArrayList<TreeNode> rightSubtree = constructTrees(i + 1, end);

			/*
			 * now looping through all left and right subtrees and connecting them to ith
			 * root below
			 */
			for (int j = 0; j < leftSubtree.size(); j++) {
				TreeNode left = leftSubtree.get(j);
				for (int k = 0; k < rightSubtree.size(); k++) {
					TreeNode right = rightSubtree.get(k);
					TreeNode node = new TreeNode(i); // making value i as root
					node.left = left; // connect left subtree
					node.right = right; // connect right subtree
					list.add(node); // add this tree to list
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII uniqueBST = new UniqueBinarySearchTreesII();
		uniqueBST.generateTrees(3);
	}
}
