package com.crystalsantos.coding.binarysearch;

public class ConvertSortedArrayToBinarySearchTree {
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

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}

		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	TreeNode sortedArrayToBST(int nums[], int start, int end) {

		if (start > end) {
			return null;
		}

		int middle = (start + end) / 2;
		TreeNode node = new TreeNode(nums[middle]);

		node.left = sortedArrayToBST(nums, start, middle - 1);
		node.right = sortedArrayToBST(nums, middle + 1, end);

		return node;
	}

	private void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.val + " ");
			inorderRec(root.right);
		}
	}

	private void run() {
		int[] nums = new int[] { -10, -3, 0, 5, 9 };
		TreeNode result = sortedArrayToBST(nums);
		inorderRec(result);
	}

	public static void main(String[] args) {
		new ConvertSortedArrayToBinarySearchTree().run();
	}
}
