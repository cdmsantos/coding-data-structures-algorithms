package com.crystalsantos.codility.facebook.trees.and.graphs;

/***
 * 
 * Validate Binary Search Tree
 * 
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3] Output: true Example 2:
 * 
 * 
 * Input: root = [5,1,4,null,null,3,6] Output: false Explanation: The root
 * node's value is 5 but its right child's value is 4.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104]. -231 <= Node.val <=
 * 231 - 1
 * 
 */
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return false;
		}

		// single node
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

	public static void main(String[] args) {
		ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
		bst.run();
	}

	private void run() {
		TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		System.out.println(isValidBST(root1));

		TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
		System.out.println(isValidBST(root2));
	}

}
